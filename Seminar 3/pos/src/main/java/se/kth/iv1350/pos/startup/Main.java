package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

/**
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main {
    /**
     * The main method used to start the application.
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
    	
        Printer printer = new Printer();
        ExternalAccountingSystemHandler eas = new ExternalAccountingSystemHandler();
        ExternalInventorySystemHandler eis = new ExternalInventorySystemHandler();

        Controller contr = new Controller(printer, eas, eis);
        View view = new View(contr);
        
        view.runFakeExecution();
    }
}
