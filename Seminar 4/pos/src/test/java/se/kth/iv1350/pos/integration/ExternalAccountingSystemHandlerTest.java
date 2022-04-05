package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.Sale;

public class ExternalAccountingSystemHandlerTest {
    private ExternalAccountingSystemHandler eas;
    public ExternalAccountingSystemHandlerTest() {
        eas = new ExternalAccountingSystemHandler();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        eas.update(100);
        double expResult = 200;
        double result = eas.getStoreBalance();
        assertEquals(expResult, result, "Expected result did not equal result");
    }  
}
