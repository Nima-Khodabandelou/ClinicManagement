package com.autotradingwiz.animalclinicmanagement.services;

import com.autotradingwiz.animalclinicmanagement.models.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
