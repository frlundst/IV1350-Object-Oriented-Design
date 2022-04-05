package se.kth.iv1350.pos.model;

/**
 * Item data transfer object, groups together variables for items.
 */
public class ItemDTO {
    private String itemDescription;
    private double price;
    private double VAT;
    
    /**
     * Creates an instance of ItemDTO.
     * @param itemDescription Describes an item.
     * @param price Price of the item
     * @param VAT  Vat of the item
     */
    public ItemDTO(String itemDescription, double price, double VAT) {
    	this.itemDescription = itemDescription;
        this.price = price;
        this.VAT = VAT;
    }
    
    /**
     * Returns the item description.
     * @return itemDescription.
     */
    public String getItemDescription() {
        return this.itemDescription;
    }
    
    /**
     * Returns price of the item.
     * @return price of the item.
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Returns VAT for the item.
     * @return VAT for the item.
     */
    public double getVAT() {
        return this.VAT;
    }
    
}