package com.example.library.service;

import com.example.library.model.MagazineDetails;
import com.example.library.repository.MagazineDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazineDetailsService {

    private final MagazineDetailsRepository magazineDetailsRepository;

    public MagazineDetailsService(MagazineDetailsRepository magazineDetailsRepository) {
        this.magazineDetailsRepository = magazineDetailsRepository;
    }

    public void addMagazineDetails(MagazineDetails magazineDetails) {
        magazineDetailsRepository.save(magazineDetails);
    }

    public void updateMagazineDetails(String id, MagazineDetails update) {
        update.setId(id);
        magazineDetailsRepository.save(update);
    }

    public void removeMagazineDetails(String magazineDetailsId) {
        MagazineDetails magazineDetails = magazineDetailsRepository.findById(magazineDetailsId);
        if (magazineDetails != null) {
            magazineDetailsRepository.delete(magazineDetails);
        }
    }

    public MagazineDetails getMagazineDetailsById(String magazineDetailsId) {
        return magazineDetailsRepository.findById(magazineDetailsId);
    }

    public List<MagazineDetails> getAllMagazineDetails() {
        return magazineDetailsRepository.findAll();
    }

}
