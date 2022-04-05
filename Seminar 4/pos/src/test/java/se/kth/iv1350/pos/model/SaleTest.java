package se.kth.iv1350.pos.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
    private Sale sale;
    private SaleDTO saleDTO;
    
    public SaleTest() {
        sale = new Sale();
        saleDTO = new SaleDTO(java.time.LocalTime.now(), 0, 0, null); 
    }

    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ItemDTO itemDTO = new ItemDTO("Karrékotlett med Ben Skivad ca 1kg ICA", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        int quantity = 1;
        String expResult = "Karrékotlett med Ben Skivad ca 1kg ICA";
        sale.addItem(item, quantity);
        String result = sale.getSaleInformation().getItems().get(0).getItemDTO().getItemDescription();
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
    @Test
    public void testAddItemTotalPrice() {
        System.out.println("addItemTotalPrice");
        ItemDTO itemDTO = new ItemDTO("Karrékotlett med Ben Skivad ca 1kg ICA", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        int quantity = 1;
        double expResult = 99;
        sale.addItem(item, quantity);
        double result = sale.getSaleInformation().getTotalPrice();
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
    @Test
    public void testAddItemTotalVAT() {
        System.out.println("addItemTotalVAT");
        ItemDTO itemDTO = new ItemDTO("Karrékotlett med Ben Skivad ca 1kg ICA", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        int quantity = 1;
        double expResult = 12;
        sale.addItem(item, quantity);
        double result = sale.getSaleInformation().getTotalVAT();
        assertEquals(expResult, result, "Expected result did not equal result");
    }

    @Test
    public void testIsDuplicateItem() {
        System.out.println("isDuplicateItem");
        ItemDTO itemDTO = new ItemDTO("Karrékotlett med Ben Skivad ca 1kg ICA", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        Item item2 = new Item(1, itemDTO, 100);
        int quantity = 1;
        sale.addItem(item, quantity);
        sale.addItem(item2, quantity);
        
        int expResult = 2;
        int result = sale.getCustomerItemsQuantity().get(0);
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
    @Test
    public void testIsNotDuplicateItem() {
        System.out.println("isNotDuplicateItem");
        ItemDTO itemDTO = new ItemDTO("Karrékotlett med Ben Skivad ca 1kg ICA", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        Item item2 = new Item(2, itemDTO, 100);
        int quantity = 1;
        sale.addItem(item, quantity);
        sale.addItem(item2, quantity);
        
        int expResult = 1;
        int result = sale.getCustomerItemsQuantity().get(0);
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
}
