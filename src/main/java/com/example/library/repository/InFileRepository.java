package com.example.library.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public abstract class InFileRepository<T> implements AbstractRepository<T> {

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private final Class<T> entity;
    private final File file;
    private final CollectionType list;

    protected InFileRepository(Class<T> entity, String filename, String dataDir) {
        this.entity = entity;
        this.file = new File(dataDir, filename);
        this.list = mapper.getTypeFactory().constructCollectionType(List.class, entity);

        ensureFileExists();
    }

    protected abstract String getId(T entity);
    protected abstract void setId(T entity, String id);

    /*
    Verifica daca exista folderul si fisierul
    Daca nu, le creeaza
     */
    private void ensureFileExists() {
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            if (!file.exists()) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, new ArrayList<>());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed creating file! ", e);
        }
    }

    /*
    Citeste din fisier toate obiectele si le pune in lista
     */
    private List<T> readAllInternal() {
        try {
            if (file.length() == 0) {
                return new ArrayList<>();
            }

            return mapper.readValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException("Failed reading! ", e);
        }
    }

    /*
    Scrie toate obiectele in fisier
     */
    private void writeAllInternal(List<T> items) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, items);
        } catch (IOException e) {
            throw new RuntimeException("Failed writing! ", e);
        }
    }

    /*
    Salveaza o entitate in fisier daca nu exista
    Daca exista, o updateaza
     */
    @Override
    public void save(T entity) {
        List<T> items = readAllInternal();

        String id = getId(entity);

        if (id == null || id.isEmpty()) {
            id = UUID.randomUUID().toString();
            setId(entity, id);
        }

        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(getId(items.get(i)), id)) {
                items.set(i, entity);
                writeAllInternal(items);
                return;
            }
        }

        items.add(entity);
        writeAllInternal(items);
    }

    /*
    Sterge o entitate din fisier daca exista
     */
    @Override
    public void delete(T entity) {
        List<T> items = readAllInternal();
        items.removeIf(e -> Objects.equals(getId(e), getId(entity)));
        writeAllInternal(items);
    }

    /*
    Cauta o entitate dupa Id
     */
    @Override
    public T findById(String id) {
        return readAllInternal().stream().filter(e -> Objects.equals(getId(e), id)).findFirst().orElse(null);
    }

    /*
    Returneaza toate entitatile din fisier
     */
    @Override
    public List<T> findAll() {
        return new ArrayList<>(readAllInternal());
    }

}