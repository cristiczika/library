package com.example.library.model;

import java.util.List;

public class Libray {
    private String id;
    private String name;
    private List <Member> members;
    private List<ReadableItem> readableItems;

    public Libray(String id, String name, List<Member> members, List<ReadableItem> readableItems) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.readableItems = readableItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<ReadableItem> getReadableItems() {
        return readableItems;
    }

    public void setReadableItems(List<ReadableItem> readableItems) {
        this.readableItems = readableItems;
    }

}
