package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;

/**
 * External accounting system handler, handles store balance.
 */
public class ExternalAccountingSystemHandler {
    private int storeBalance;
    
    /**
     * Updates store balance with the satrting amount.
     */
    public ExternalAccountingSystemHandler() {
        this.storeBalance = 100; //Starting value
    }
    
    /**
     * Updates the store balance with amount.
     * @param amount Money recived from the sale.
     */
    public void update(double amount) {
    	this.storeBalance += amount;
    }
    
    /**
     * Returns store balance.
     * @return returns store balance.
     */
    public int getStoreBalance() {
    	return this.storeBalance;
    }
}
