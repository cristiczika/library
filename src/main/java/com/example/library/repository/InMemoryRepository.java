package com.example.library.repository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public abstract class InMemoryRepository<T> implements AbstractRepository<T> {

    private final List<T> storage = new ArrayList<>();
    protected abstract String getId(T entity);
    protected abstract void setId(T entity, String id);

    @Override
    public void save(T entity) {
        String id = getId(entity);

        if (id == null || id.isEmpty()) {
            id = UUID.randomUUID().toString();
            setId(entity, id);
        }

        for (int i = 0; i < storage.size(); i++) {
            if (getId(storage.get(i)).equals(id)) {
                storage.set(i, entity);
                return;
            }
        }

        storage.add(entity);
    }

    @Override
    public void delete(T entity) {
        storage.removeIf(e -> Objects.equals(getId(e), getId(entity)));
    }

    @Override
    public T findById(String id) {
        return storage.stream()
                .filter(e -> Objects.equals(getId(e), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage);
    }
}