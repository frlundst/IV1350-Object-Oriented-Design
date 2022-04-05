package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.model.SaleDTO;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;

public class ControllerTest {
    private Controller contr;
    
    @BeforeEach
    public void setUp() {
        Printer printer = new Printer();
        ExternalAccountingSystemHandler eas = new ExternalAccountingSystemHandler();
        ExternalInventorySystemHandler eis = new ExternalInventorySystemHandler();
        contr = new Controller(printer, eas, eis);
    }

    @Test
    public void testStartSale() {
        System.out.println("startSale");
        SaleDTO result = contr.startSale();
    }

    @Test
    public void testEnterItem() {
        System.out.println("enterItem");
        contr.startSale();
        
        int itemIdentifier = 1;
        int quantity = 2;
        String expResult = "Karrékotlett med Ben Skivad ca 1kg ICA";
        SaleDTO saleDTO = contr.enterItem(itemIdentifier, quantity);
        String result = saleDTO.getItems().get(0).getItemDTO().getItemDescription();
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
    public void testEnterNullItem() {
        System.out.println("enterNullItem");
        contr.startSale();
        
        int itemIdentifier = 8;
        int quantity = 2;
        SaleDTO expResult = null;
        SaleDTO result = contr.enterItem(itemIdentifier, quantity);
        assertEquals(expResult, result, "Expected result did not equal result");
    }

    @Test
    public void testEndSale() {
        System.out.println("endSale");
        contr.startSale();
        SaleDTO saleDTO = contr.enterItem(1, 2);
        int expResult = 98;
        contr.endSale();
        int result = saleDTO.getItems().get(0).getStoreQuantity();
        assertEquals(expResult, result, "Expected result did not equal result");  
    }
    
    @Test
    public void testPay() {
        System.out.println("pay");
        contr.startSale();
        contr.enterItem(1, 2);
        contr.endSale();
        
        double amount = 300;
        String paymentMethod = "Cash";
        double expResult = 102;
        double result = contr.pay(amount, paymentMethod);
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
    @Test
    public void testPayLess() {
        System.out.println("pay less");
        contr.startSale();
        contr.enterItem(1, 2);
        contr.endSale();
        
        double amount = 100;
        String paymentMethod = "Cash";
        double expResult = -98;
        double result = contr.pay(amount, paymentMethod);
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    
    @Test
    public void testPayEqual() {
        System.out.println("pay equal");
        contr.startSale();
        contr.enterItem(1, 2);
        contr.endSale();
        
        double amount = 198;
        String paymentMethod = "Cash";
        double expResult = 0;
        double result = contr.pay(amount, paymentMethod);
        assertEquals(expResult, result, "Expected result did not equal result");
    }
    

    @Test
    public void testPrint() {
        System.out.println("print");
        contr.startSale();
        contr.print();
    }
    
}
