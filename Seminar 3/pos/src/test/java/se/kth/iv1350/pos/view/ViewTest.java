/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.controller.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Casper
 */
public class ViewTest {
    private View view;
    
    public ViewTest() {
        ExternalAccountingSystemHandler eas = new ExternalAccountingSystemHandler();
        ExternalInventorySystemHandler eis = new ExternalInventorySystemHandler();
        Printer printer = new Printer();
        
        Controller contr = new Controller(printer,eas,eis);
        view = new View(contr);
    }

    @Test
    public void testRunFakeExecution() {
        System.out.println("runFakeExecution");
        view.runFakeExecution();
    }
    
}
