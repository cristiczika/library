package com.example.library.model;

import java.util.List;

public class MagazineDetails extends Publication {

    private String publisher;

    public MagazineDetails(String id, String title, List<ReadableItem> copies, String publisher) {
        super(id, title, copies);
        this.publisher = publisher;
    }

    String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
