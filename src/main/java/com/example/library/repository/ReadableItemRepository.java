package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class ReadableItemRepository extends InFileRepository<ReadableItem> {

    public ReadableItemRepository() {
        super(ReadableItem.class, "readableitems.json", "src/main/resources/data");
    }

    @Override
    protected String getId(ReadableItem readableItem) {
        return readableItem.getId();
    }

    @Override
    protected void setId(ReadableItem readableItem, String id) {
        readableItem.setId(id);
    }

}