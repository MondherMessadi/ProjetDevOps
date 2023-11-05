package tn.esprit.spring.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FournisseurTest {

    @Autowired
    IFournisseurService ifs;

    @Test
    @Order(1)
    public void testRetreiveAllOp(){
        List<Fournisseur> frn = ifs.retrieveAllFournisseurs();
        Assertions.assertEquals(0, frn.size());
    }


}