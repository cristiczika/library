package com.example.library.service;

import com.example.library.model.ReadableItem;
import com.example.library.repository.ReadableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadableItemService {

    private final ReadableItemRepository readableItemRepository;

    public ReadableItemService(ReadableItemRepository readableItemRepository) {
        this.readableItemRepository = readableItemRepository;
    }

    public ReadableItem addReadableItem(ReadableItem readableItem) {
        return readableItemRepository.save(readableItem);
    }

    public boolean removeReadableItem(String readableItemId) {
        return readableItemRepository.deleteById(readableItemId);
    }

    public Optional<ReadableItem> getReadableItemById(String readableItemId) {
        return readableItemRepository.findById(readableItemId);
    }

    public List<ReadableItem> getAllReadableItems() {
        return readableItemRepository.findAll();
    }

}
