package se.kth.iv1350.pos.model;

import java.util.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

/**
 * Represents the recepit of the entire sale.
 */
public class Receipt {
    private SaleDTO saleInformation;
    private java.time.LocalTime time;
    private String nameOfStore;
    private double totalDiscount;
    private double totalVAT;
    private double totalPrice;
    private List<Item> nameOfItems;
    
    /**
     * Creates an instance of a receipt.
     * @param saleInformation Contains the saleDTO, which has all info about the sale.
     */
    public Receipt(SaleDTO saleInformation) {
        this.saleInformation = saleInformation;
        this.nameOfStore = saleInformation.getNameOfStore();
        this.totalVAT = saleInformation.getTotalVAT();
        this.totalPrice = saleInformation.getTotalPrice();
        this.nameOfItems = saleInformation.getItems();
    }
    
    /**
     * Returns current time.
     * @return time is the current time of the sale.
     */
    public java.time.LocalTime getTime() {
        return this.time;
    }
    
    /**
     * Returns name of the store.
     * @return nameOfStore is the name of the store.
     */
    public String getNameOfStore() {
        return this.nameOfStore;
    }
    
    /**
     * Returns the total discount.
     * @return totalDiscount is the total discount of the sale.
     */
    public double getTotalDiscount() {
        return this.totalDiscount;
    }
    
    /**
     * Returns the total VAT.
     * @return totalVAT is the total VAT of the sale.
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
    
    /**
     * Returns the total price.
     * @return totalPrice is the total price of the sale.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    /**
     * Returns a arraylist containing the names of all items.
     * @return nameOfItems is the list of all items.
     */
    public List<Item> getNameOfItems() {
        return this.nameOfItems;
    }
}
