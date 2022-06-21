package com.autotradingwiz.animalclinicmanagement.services;

import com.autotradingwiz.animalclinicmanagement.models.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
