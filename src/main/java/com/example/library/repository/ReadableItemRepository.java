package com.example.library.repository;

import com.example.library.model.ReadableItem;
import com.example.library.model.ReadableItemStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ReadableItemRepository {

    private final List<ReadableItem> items = new ArrayList<>(Arrays.asList(
            new ReadableItem("R1", "B1", "BC101", ReadableItemStatus.AVAILABLE),
            new ReadableItem("R2", "B2", "BC102", ReadableItemStatus.AVAILABLE),
            new ReadableItem("R3", "B3", "BC103", ReadableItemStatus.BORROWED),
            new ReadableItem("R4", "B4", "BC104", ReadableItemStatus.AVAILABLE),
            new ReadableItem("R5", "M1", "BC105", ReadableItemStatus.RESERVED)
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