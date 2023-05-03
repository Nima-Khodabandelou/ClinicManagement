package com.autotradingwiz.animalclinicmanagement.bootstrap;

import com.autotradingwiz.animalclinicmanagement.models.*;

import com.autotradingwiz.animalclinicmanagement.services.OwnerService;

import com.autotradingwiz.animalclinicmanagement.services.PetTypeService;

import com.autotradingwiz.animalclinicmanagement.services.SpecialityService;

import com.autotradingwiz.animalclinicmanagement.services.VetService;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Amir");
        owner1.setLastName("Khodabandelou");
        owner1.setAddress("123 Azadi");
        owner1.setCity("Karaj");
        owner1.setTelephone("54365436");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Max");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Nima");
        owner2.setLastName("Khodabandelou");
        owner2.setAddress("567 Behrad");
        owner2.setCity("Tabriz");
        owner2.setTelephone("09243422");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Pishi");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Load owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kamran");
        vet1.setLastName("Mirzaei");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Keyvan");
        vet2.setLastName("Ranjkesh");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Load vets...");
        
    }
}
