package com.example.library.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class InFileRepository<T> implements AbstractRepository<T> {

    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule())
            .disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private final Class<T> entityClass;
    private final File dataFile;
    private final CollectionType listType;

    protected InFileRepository(Class<T> entityClass, String filename, String dataDir) {
        this.entityClass = entityClass;
        this.dataFile = new File(dataDir, filename);
        this.listType = mapper.getTypeFactory().constructCollectionType(List.class, entityClass);

        ensureFileExistsWithArray();
    }

    protected abstract String getId(T entity);
    protected abstract void setId(T entity, String id);

    @Override
    public void save(T entity) {
        lock.writeLock().lock();
        try {
            List<T> items = readAllInternal();

            String id = getId(entity);
            if (id == null || id.isEmpty()) {
                id = UUID.randomUUID().toString();
                setId(entity, id);
            }

            boolean updated = false;
            for (int i = 0; i < items.size(); i++) {
                if (Objects.equals(getId(items.get(i)), id)) {
                    items.set(i, entity);
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                String finalId = id;
                if (items.stream().anyMatch(e -> Objects.equals(getId(e), finalId))) {
                    id = UUID.randomUUID().toString();
                    setId(entity, id);
                }
                items.add(entity);
            }

            writeAllInternal(items);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(T entity) {
        lock.writeLock().lock();
        try {
            List<T> items = readAllInternal();
            String id = getId(entity);
            items.removeIf(e -> Objects.equals(getId(e), id));
            writeAllInternal(items);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public T findById(String id) {
        lock.readLock().lock();
        try {
            return readAllInternal().stream().filter(e -> Objects.equals(getId(e), id)).findFirst().orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<T> findAll() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(readAllInternal());
        } finally {
            lock.readLock().unlock();
        }
    }

    private List<T> readAllInternal() {
        ensureFileExistsWithArray();
        try {
            if (dataFile.length() == 0) {
                return new ArrayList<>();
            }
            return mapper.readValue(dataFile, listType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + dataFile.getAbsolutePath(), e);
        }
    }

    private void writeAllInternal(List<T> items) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(dataFile, items);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write " + dataFile.getAbsolutePath(), e);
        }
    }

    private void ensureFileExistsWithArray() {
        try {
            File parent = dataFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!dataFile.exists()) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(dataFile, new ArrayList<>());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize " + dataFile.getAbsolutePath(), e);
        }
    }
}