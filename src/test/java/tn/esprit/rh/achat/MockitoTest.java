import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ProduitTest {

    @Test
    void testGettersAndSetters() {
        // Create a mock Stock
        Stock stockMock = mock(Stock.class);
        
        // Create a mock CategorieProduit
        CategorieProduit categorieProduitMock = mock(CategorieProduit.class);

        // Create a Set of DetailFacture (mocked)
        Set<DetailFacture> detailFactureSetMock = new HashSet<>();

        // Create a Produit instance
        Produit produit = new Produit();
        produit.setIdProduit(1L);
        produit.setCodeProduit("ABC123");
        produit.setLibelleProduit("Test Produit");
        produit.setPrix(25.0f);
        produit.setDateCreation(new Date());
        produit.setDateDerniereModification(new Date());
        produit.setStock(stockMock);
        produit.setDetailFacture(detailFactureSetMock);
        produit.setCategorieProduit(categorieProduitMock);

        // Verify the getters
        assertEquals(1L, produit.getIdProduit());
        assertEquals("ABC123", produit.getCodeProduit());
        assertEquals("Test Produit", produit.getLibelleProduit());
        assertEquals(25.0f, produit.getPrix());
        assertEquals(stockMock, produit.getStock());
        assertEquals(detailFactureSetMock, produit.getDetailFacture());
        assertEquals(categorieProduitMock, produit.getCategorieProduit());

        // You can add more assertions as needed

        // Verify interactions with mocked objects
        verify(stockMock, times(1)).addProduit(produit);
        verify(categorieProduitMock, times(1)).addProduit(produit);
    }
}
