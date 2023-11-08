package tn.esprit.spring.achat;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.achat.entities.Equipe;
import tn.esprit.spring.achat.entities.Etudiant;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class mockito {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Produit produit;

    @Mock
    private CategorieProduit categorie;
    @Test
    public void testProduitCategorieRelationship() {
        // Create some mock Etudiant objects
        Produit produit1 = new Produit();
        produit1.setidProduit(1);
        produit1.setlibelleProduit("CREATINE");

        // Create a mock Equipe
        CategorieProduit categorie = new CategorieProdui();
        CategorieProduit.setidCategorieProduit(1);
        CategorieProduit.setlibelleCategorie("Complèment");

        // Define the behavior for the relationship between Equipe and Etudiant
        Set<Produit> produits = new HashSet<>();
        produits.add(produit1);
        categorie.setProduits(produits);

        // Verify that the relationship is correctly set up
        Assertions.assertEquals(1, produit.getProduits().size());
        Assertions.assertEquals("CREATINE", produit.getProduits().iterator().next().getlibelleProduit());
    }
}
