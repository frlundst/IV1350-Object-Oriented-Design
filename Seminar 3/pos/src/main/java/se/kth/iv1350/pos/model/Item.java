package se.kth.iv1350.pos.model;

/**
 * This class represents one item.
 */
public class Item {
    private ItemDTO itemDTO;
    private int storeQuantity;
    private int itemIdentifier; 
    
    /**
     * Creates an instance of the Item class.
     * @param itemIdentifier The item's identifier
     * @param itemDTO The data transfer object for the item.
     * @param quantity The quantitiy of the item.
     */
    public Item(int itemIdentifier, ItemDTO itemDTO, int quantity) {
        this.itemIdentifier = itemIdentifier;
        this.itemDTO = itemDTO;
        this.storeQuantity = quantity;
    }
    
    /**
     * Returns item identifier
     * @return item identifier.
     */
    public int getItemIdentifier() {
    	return this.itemIdentifier;
    }
    
    /**
     * Returns store quantity of an item in the store.
     * @return quantity of item in store.
     */
    public int getStoreQuantity() {
    	return this.storeQuantity;
    }

    /**
     * Updates the quantity of an item in the store.
     * @param bought_quantity The quantity of an item that the customer has purchased.
     */
    public void updateQuantity(int bought_quantity){
    	this.storeQuantity -= bought_quantity;
    }
    
    /**
     * Returns the DTO of an item.
     * @return ItemDTO of the item.
     */
    public ItemDTO getItemDTO() {
    	return this.itemDTO; 
    }
}
