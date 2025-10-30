package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class ReadableItemRepository extends InMemoryRepository<ReadableItem> {

    @Override
    protected String getId(ReadableItem author) {
        return author.getId();
    }

    @Override
    protected void setId(ReadableItem author, String id) {
        author.setId(id);
    }

}