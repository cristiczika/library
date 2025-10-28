package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String id;
    private String name;
    private List<Member> members;
    private List<ReadableItem> readableItems;

    public Library() {
        this.members = new ArrayList<>();
        this.readableItems = new ArrayList<>();
    }

    public Library(String id, String name) {
        this();
        this.id = id;
        this.name = name;
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

    public void addMember(Member member) {
        if (members == null) {
            members = new ArrayList<>();
        }

        members.add(member);
    }

    public List<ReadableItem> getReadableItems() {
        return readableItems;
    }

    public void setReadableItems(List<ReadableItem> readableItems) {
        this.readableItems = readableItems;
    }

    public void addReadableItem(ReadableItem item) {
        if (readableItems == null) {
            readableItems = new ArrayList<>();
        }

        readableItems.add(item);
    }

}
