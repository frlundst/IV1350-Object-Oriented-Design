package se.kth.iv1350.pos.controller;

import java.util.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;

/**
 * The controller of the program. Which recives the different external Systems
 * And add some items to the eis for test purposes.
 */
public class Controller {
    private Sale sale;
    private Printer printer; 
    private ExternalAccountingSystemHandler eas;
    private ExternalInventorySystemHandler eis;
    
    private List<SaleObserver> saleObservers = new ArrayList<>();
    
    /**
	 * Generates an instance of the controller.
	 * @param printer a receipt printer.
	 * @param eas an external accounting handler.
	 * @param eis an external inventory handler.
	 */
    public Controller(Printer printer, ExternalAccountingSystemHandler eas, ExternalInventorySystemHandler eis) {
        this.printer = printer;
        this.eas = eas;
        this.eis = eis;
        eis.addItem();
    }
    
    /**
	 * Starts a new sale. Must be called before anything else.
	 * @return getSaleInformation which returns the Sale Information.
	 */
    public SaleDTO startSale() {
        this.sale = new Sale();
        for(SaleObserver obs : saleObservers)
            sale.addSaleObserver(obs);
        return sale.getSaleInformation();
    }
    
    /**
     * Adds an item to the sale.
     * There is two exceptions in this method. 
     * One is for if an invalid item identifier are entered and the other one is if the server is offline.
     * @param itemIdentifier The identifier of the item. Not handled if invalid.
     * @param quantity The quantity of the entered item.
     * @return SaleDTO, which is to be shown on the screen in view.
     */
    public SaleDTO enterItem(int itemIdentifier, int quantity) throws ItemIdentifierNotValidException, DataBaseOfflineException {
        try{
            Item item = eis.search(itemIdentifier); 
            if(item.getStoreQuantity() >= quantity) {
                sale.addItem(item, quantity);	
            }
            return this.sale.getSaleInformation();
        } catch(ItemIdentifierNotValidException | DataBaseOfflineException exception){
            System.err.println("DEVELOPER (log): " + exception.getMessage());
            throw exception;
        }
    }
    
    /**
	 * Ends a sale.
	 * @return returns the SaleDTO of the finished sale.
	 */
    public SaleDTO endSale() {
    	eis.update(this.sale);
    	return this.sale.getSaleInformation();
    }
    
    /**
	 * Handles payment. Updates the accounting system and returns
	 * @param amount describes the amount paid
	 * @param paymentMethod describes what type of payment
	 * @return change, which returns the amount change.
	 */
    public double pay(double amount, String paymentMethod) {
    	double change = amount - sale.getSaleInformation().getTotalPrice();
    	
    	if(change >= 0){
    		this.eas.update(amount - change);
    	}

    	return change;
    }
    
    /**
     * printer prints the receipt for the sale.
     */
    public void print() {
    	printer.print(this.sale.getReceipt(sale));
    }
    
    /**
     * Observer will be notified when a new sale has been made.
     * @param obs Is the variable for the observer to notify. 
     */
    public void addSaleObserver(SaleObserver obs){
        saleObservers.add(obs);
    }

}