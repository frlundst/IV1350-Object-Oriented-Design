package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.integration.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item item;
    private ExternalInventorySystemHandler eis;
    
    public ItemTest() {
        eis = new ExternalInventorySystemHandler();
        eis.addItem();
    }

    @Test
    public void testUpdateQuantity() {
        System.out.println("updateQuantity");
        int bought_quantity = 1;
        eis.addItem();
        item = eis.getItems().get(0);
        int expResult = 99;
        item.updateQuantity(bought_quantity);
        int result = eis.getItems().get(0).getStoreQuantity();
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
}
