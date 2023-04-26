package com.autotradingwiz.animalclinicmanagement.services;


import com.autotradingwiz.animalclinicmanagement.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
