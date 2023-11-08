package tn.esprit.spring.service;


import org.junit.jupiter.api.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tn.esprit.rh.achat.entities.Operateur;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class OperatorServiceImplTest {
    private Operateur operateur;


    @BeforeEach
    public void setUp() {
        operateur = new Operateur();
    }

   /* @Test
    public void testRetrieveAllOp() {
        List<Operateur> ops = ios.retrieveAllOperateurs();
        Assertions.assertEquals(0, ops.size());
    }*/

    @Test
    public void testOperateur() {
        operateur.setIdOperateur(10L);
        operateur.setNom("Benadel");
        operateur.setPrenom("MohamedHassen");

        assertEquals(10L, operateur.getIdOperateur());
        assertEquals("Benadel", operateur.getNom());
        assertEquals("MohamedHassen", operateur.getPrenom());
    }

    @Test
    public void testOperateurNotNull() {
        operateur.setIdOperateur(10L);
        operateur.setNom("Benadel");
        operateur.setPrenom("MohamedHassen");

        assertNotNull(operateur.getIdOperateur());
        assertNotNull(operateur.getNom());
        assertNotNull(operateur.getPrenom());


    }


}
