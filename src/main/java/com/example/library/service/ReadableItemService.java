package com.example.library.service;

import com.example.library.model.ReadableItem;
import com.example.library.repository.ReadableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadableItemService {

    private final ReadableItemRepository readableItemRepository;

    public ReadableItemService(ReadableItemRepository readableItemRepository) {
        this.readableItemRepository = readableItemRepository;
    }

    public void addReadableItem(ReadableItem readableItem) {
        readableItemRepository.save(readableItem);
    }

    public void updateReadableItem(String id, ReadableItem update) {
        update.setId(id);
        readableItemRepository.save(update);
    }

    public void removeReadableItem(String readableItemId) {
        ReadableItem readableItem = readableItemRepository.findById(readableItemId);
        if (readableItem != null) {
            readableItemRepository.delete(readableItem);
        }
    }

    public ReadableItem getReadableItemById(String readableItemId) {
        return readableItemRepository.findById(readableItemId);
    }

    public List<ReadableItem> getAllReadableItems() {
        return readableItemRepository.findAll();
    }

}
