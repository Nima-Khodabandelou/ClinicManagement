package com.autotradingwiz.animalclinicmanagement.services;

import com.autotradingwiz.animalclinicmanagement.models.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
