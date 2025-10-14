package com.apartment.service;

import com.apartment.entity.Apartment;
import com.apartment.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    private final ApartmentRepository repo;

    public ApartmentService(ApartmentRepository repo) {
        this.repo = repo;
    }

    public List<Apartment> getAllApartments() {
        return repo.findAll();
    }

    public Apartment getApartmentById(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Apartment not found"));
    }

    public Apartment createApartment(Apartment apartment) {
        return repo.save(apartment);
    }

    public Apartment updateApartment(int id, Apartment apartment) {
        Apartment existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Apartment not found"));
        existing.setName(apartment.getName());
        existing.setLocation(apartment.getLocation());
        existing.setRent(apartment.getRent());
        existing.setStatus(apartment.getStatus());
        return repo.save(existing);
    }

    public void deleteApartment(int id) {
        repo.deleteById(id);
    }
}
