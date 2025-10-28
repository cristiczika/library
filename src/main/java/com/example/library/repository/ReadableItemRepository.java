package com.example.library.repository;

import com.example.library.model.ReadableItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ReadableItemRepository {

    private final List<ReadableItem> items = new ArrayList<>(Arrays.asList(
            new ReadableItem("R1", "B1", "BC101", "Available"),
            new ReadableItem("R2", "B2", "BC102", "Available"),
            new ReadableItem("R3", "B3", "BC103", "Borrowed"),
            new ReadableItem("R4", "B4", "BC104", "Available"),
            new ReadableItem("R5", "M1", "BC105", "Reserved")
    ));

    public List<ReadableItem> findAll() {
        return items;
    }

    public Optional<ReadableItem> findById(String id) {
        return items.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public ReadableItem save(ReadableItem item) {
        items.removeIf(i -> i.getId().equals(item.getId()));
        items.add(item);
        return item;
    }

    public boolean deleteById(String id) {
        return items.removeIf(i -> i.getId().equals(id));
    }
}