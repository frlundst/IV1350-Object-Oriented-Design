package se.kth.iv1350.pos.integration;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.ItemDTO;
import se.kth.iv1350.pos.model.Sale;

public class ExternalInventorySystemHandlerTest {
    private ExternalInventorySystemHandler eis;
    
    public ExternalInventorySystemHandlerTest() {
           eis = new ExternalInventorySystemHandler();  
    }

    @Test
    public void testAddItem() {
        System.out.println("addItem");
        eis.addItem();
        
        ItemDTO itemDTO = new ItemDTO("Karrékotlett med Ben Skivad ca 1kg ICA", 87, 12);
        String expResult = itemDTO.getItemDescription();
        String result = eis.getItems().get(0).getItemDTO().getItemDescription();
        assertEquals(expResult, result, "Expected result did not equal result");
        
    }

    @Test
    public void testSearchValid() {
        System.out.println("search valid identifier");
        eis.addItem();
        int itemIdentifier = 1;

        String expResult = "Karrékotlett med Ben Skivad ca 1kg ICA";
        Item item = eis.search(itemIdentifier);
        String result = item.getItemDTO().getItemDescription();
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
    @Test
    public void testSearchNotValid() {
        System.out.println("search not valid identifier");
        eis.addItem();
        int itemIdentifier = 5;

        Item expResult = null;
        Item result = eis.search(itemIdentifier);
        assertEquals(expResult, result, "Expected result did not equal result");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Sale sale = new Sale();
        eis.addItem();
        
        sale.addItem(eis.getItems().get(0), 1); 
        eis.update(sale);
        int expResult = 99;
        int result = sale.getItems().get(0).getStoreQuantity();
        assertEquals(expResult, result, "Expected result did not equal result");
    }   
}
