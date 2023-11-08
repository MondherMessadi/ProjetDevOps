package tn.esprit.spring.service;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {FournisseurServiceImpl.class})
public class FournisseurTest {

    private Fournisseur fournisseur;


    @Test
    public void testFournisseur() {
        fournisseur.setIdFournisseur(26L);
        fournisseur.setCode("26");
        fournisseur.setLibelle("Mondher");
        assertEquals(26L,fournisseur.getIdFournisseur().longValue());
        assertEquals("Messadi", fournisseur.getCode());
        assertEquals("Mondher", fournisseur.getLibelle());
    }

    @Test
    public void testFournisseurNotNull() {
        fournisseur.setIdFournisseur(26L);
        fournisseur.setCode("26");
        fournisseur.setLibelle("Mondher");

        assertNotNull(fournisseur.getIdFournisseur());
        assertNotNull(fournisseur.getCode());
        assertNotNull(fournisseur.getLibelle());


    }
/*
    private FournisseurServiceImpl service;
    private FournisseurRepository repository;



    @Test
    public void getFournisseurTest(){
        System.out.println(" get test fournisseur");
        long id = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        long id2 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        repository = mock(FournisseurRepository.class);
        service = new FournisseurServiceImpl(repository);

        List<Fournisseur> fournisseurList = new ArrayList<>();
        fournisseurList.add(new Fournisseur(id,"Mondher","Messadi"));
        fournisseurList.add(new Fournisseur(id2,"Messadi","Mondher"));
        when(repository.findAll()).thenReturn(fournisseurList);

    }

*/
}
