package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.controller.Controller;
import java.time.*;
import java.util.*;

/**
 * Represents one sale, one customer.
 */
public class Sale {
    private LocalTime time; 
    private SaleDTO saleInformation;
    private Receipt receipt;
    private List<Item> items;
    private List<Integer> customerItemsQuantity = new ArrayList<>();
    private double totalVAT;
    private double totalPrice;

    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
	 * Creates a new instance of sale and saves the time.
	 */
    public Sale () {
    	this.time = LocalTime.now();
    	this.items = new ArrayList<>();
    	this.saleInformation = new SaleDTO(time, 0, 0, null);
    }

    /**
	 * Returns an arraylist with all items of the class "Item".
	 * @return items an arraylist containing all items.
	 */
    public List<Item> getItems() {
    	return this.items;
    }

    /**
	 * Returns the customer's item quantity.
	 * @return customerItemsQuantity quantity of items the customer wants to buy.
	 */
    public List<Integer> getCustomerItemsQuantity(){
    	return this.customerItemsQuantity;
    }

    /**
	 * Returns the sale information for the sale.
	 * @return saleInformation contains the information of the sale.
	 */
    public SaleDTO getSaleInformation() {
        return this.saleInformation;
    }
    
    /**
	 * Adds an item to the current sale.
	 * @param item the item that is being added.
	 * @param quantity the quantity of the item being added.
	 */
    public void addItem(Item item, int quantity) {
    	updateTotalVAT(item.getItemDTO().getVAT(), quantity);
    	updateTotalPrice(item.getItemDTO().getPrice(), quantity, (item.getItemDTO().getVAT()));
        isDuplicateItem(item, quantity);
    }
    /**
	 * Handles duplicate items by increasing the quantity by one for the given item.
	 * @param currentItem the duplicate item.
	 * @param quantity the quantity of this item.
	 */
    private void isDuplicateItem(Item item, int quantity) {
        boolean found = false;
    	for(Item currentItem : items) {
    		if(currentItem.getItemIdentifier() == item.getItemIdentifier()) {   
    			found = true;
    			customerItemsQuantity.set(items.indexOf(currentItem), (customerItemsQuantity.get(items.indexOf(currentItem)) + quantity));
    		}
    	}
        if(found == false) {
    		updateItems(item);
                customerItemsQuantity.add(quantity);
    	}
    }
    
    /**
	 * Returns the receipt.
	 * @param sale the sale that is being handled.
	 * @return recepit the receipt of the sale.
	 */
    public Receipt getReceipt(Sale sale) {
        notifyObservers();
        this.receipt = new Receipt(sale.getSaleInformation());
    	return receipt;
    }
    
        
    	/**
     * This method updates the total price for the sale.
     * @param amount the cost of the item.
     * @param quantity the quantity of the item.
     * @param totalVAT the total VAT
     */
	private void updateTotalPrice(double amount, int quantity, double totalVAT) {
		this.totalPrice += (amount * quantity) + (totalVAT * (double)quantity);
                this.saleInformation = new SaleDTO(this.time, this.totalVAT, this.totalPrice, this.items);
	}

	/**
     * Updates the total VAT for the entire sale.
     * @param amount the price of the item.
     * @param quantity the quantity of the item.
     */
	private void updateTotalVAT(double vat, int quantity) {
		this.totalVAT += (vat* quantity);
                this.saleInformation = new SaleDTO(this.time, this.totalVAT, this.totalPrice, this.items);
	}

    /**
    * Adds the item to the arraylist nameOfItems.
    * @param item the item being added to the list.
    */
    private void updateItems(Item item) {
            items.add(item);
            this.saleInformation = new SaleDTO(this.time, this.totalVAT, this.totalPrice, this.items);
    }
    
    private void notifyObservers(){
        for(SaleObserver obs : saleObservers){
            obs.newSale(this.totalPrice);
        }
    }
        
    /**
     * Observer will be notified when a new sale has been made.
     * @param obs Is the variable for the observer to notify. 
     */
    public void addSaleObserver(SaleObserver obs){
        saleObservers.add(obs);
    }
}
