package tn.esprit.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StockServiceImplTest {

   /* @Mock
    private StockRepository stockRepository;*/

  //  @InjectMocks
    //private StockServiceImpl stockService;
private Stock stock;
    @BeforeEach
    public void setUp() {
        stock = new Stock();
    }

    /*@Test
    public void testRetrieveAllStocks() {
        // Arrange
        List<Stock> stocks = new ArrayList<>();
        // add some stocks to the list...

        // Mock the behavior of the stockRepository
        when(stockRepository.findAll()).thenReturn(stocks);

        // Act
        List<Stock> result = stockService.retrieveAllStocks();

        // Assert
        assertEquals(stocks.size(), result.size());
        // Add more assertions based on your requirements
    }*/

    @Test
    public void testAddStock() {
        // Arrange
        Stock stockToAdd = new Stock(/* set necessary properties */);
        stockToAdd.setIdStock(1L);
        stockToAdd.setLibelleStock("STOCK");
        stockToAdd.setQte(3);
        stockToAdd.setQteMin(0);
        assertNotNull(stockToAdd.getIdStock());
        assertNotNull(stockToAdd.getLibelleStock());
        assertNotNull(stockToAdd.getQte());
        assertNotNull(stockToAdd.getQteMin());
    }

    // Similar tests for other methods (deleteStock, updateStock, retrieveStock, retrieveStatusStock)...

}
