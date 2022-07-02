package com.autotradingwiz.animalclinicmanagement.bootstrap;

import com.autotradingwiz.animalclinicmanagement.models.Owner;
import com.autotradingwiz.animalclinicmanagement.models.Vet;
import com.autotradingwiz.animalclinicmanagement.services.OwnerService;
import com.autotradingwiz.animalclinicmanagement.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Amir");
        owner1.setLastName("Khodabandelou");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Nima");
        owner1.setLastName("Khodabandelou");

        ownerService.save(owner2);

        System.out.println("Load owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Kamran");
        vet1.setLastName("Mirzaei");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Keyvan");
        vet1.setLastName("Ranjbar");

        vetService.save(vet2);

        System.out.println("Load vets...");
    }
}
