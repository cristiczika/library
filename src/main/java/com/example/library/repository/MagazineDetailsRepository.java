package com.example.library.repository;

import com.example.library.model.MagazineDetails;
import com.example.library.model.ReadableItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MagazineDetailsRepository {

    private final List<MagazineDetails> magazines = new ArrayList<>(Arrays.asList(
            new MagazineDetails("M1", "National Geographic", new ArrayList<>(), "NatGeo"),
            new MagazineDetails("M2", "Science Weekly", new ArrayList<>(), "The Guardian"),
            new MagazineDetails("M3", "Time Magazine", new ArrayList<>(), "Time Inc.")
    ));

    public List<MagazineDetails> findAll() {
        return magazines;
    }

    public Optional<MagazineDetails> findById(String id) {
        return magazines.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public MagazineDetails save(MagazineDetails magazine) {
        magazines.removeIf(m -> m.getId().equals(magazine.getId()));
        magazines.add(magazine);
        return magazine;
    }

    public boolean deleteById(String id) {
        return magazines.removeIf(m -> m.getId().equals(id));
    }
}