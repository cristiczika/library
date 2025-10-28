package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Publication {

    private String id;
    private String title;
    private List<ReadableItem> copies;

    public Publication() {
        this.copies = new ArrayList<>();
    }

    public Publication(String id, String title) {
        this();
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ReadableItem> getCopies() {
        return copies;
    }

    public void setCopies(List<ReadableItem> copies) {
        this.copies = copies;
    }

    public void addCopy(ReadableItem copy) {
        if (copies == null) {
            copies = new ArrayList<>();
        }

        copies.add(copy);
    }

}