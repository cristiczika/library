package com.example.library.service;

import com.example.library.model.MagazineDetails;
import com.example.library.repository.MagazineDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagazineDetailsService {

    private final MagazineDetailsRepository magazineDetailsRepository;

    public MagazineDetailsService(MagazineDetailsRepository magazineDetailsRepository) {
        this.magazineDetailsRepository = magazineDetailsRepository;
    }

    public MagazineDetails addMagazineDetails(MagazineDetails magazineDetails) {
        return magazineDetailsRepository.save(magazineDetails);
    }

    public boolean removeMagazineDetails(String magazineDetailsId) {
        return magazineDetailsRepository.deleteById(magazineDetailsId);
    }

    public Optional<MagazineDetails> getMagazineDetailsById(String magazineDetailsId) {
        return magazineDetailsRepository.findById(magazineDetailsId);
    }

    public List<MagazineDetails> getAllMagazineDetails() {
        return magazineDetailsRepository.findAll();
    }

}
