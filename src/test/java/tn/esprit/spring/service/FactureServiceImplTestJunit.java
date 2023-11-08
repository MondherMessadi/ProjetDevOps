package tn.esprit.spring.service;


import org.junit.jupiter.api.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Operateur;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class FactureServiceImplTestJunit {
    private Facture facture;




    @BeforeEach
    public void setUp() {
        facture = new Facture();
    }


    @Test
    public void testFacture() {
        facture.setArchivee(true); ;
        facture.setIdFacture(2L);
        facture.setMontantFacture(123);
        facture.setMontantRemise(12313);

        assertEquals(true, facture.getArchivee());

        assertEquals(2L, facture.getIdFacture());

        assertEquals(123, facture.getMontantFacture());

        assertEquals(12313, facture.getMontantRemise());
    }




}