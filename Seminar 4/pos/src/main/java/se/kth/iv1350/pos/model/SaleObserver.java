package se.kth.iv1350.pos.model;
/**
 * Interface SaleObserver is a abstract class 
 * that groups together the newSale body.
 */
public interface SaleObserver {
    /**
     * @param totalPrice receives the 
     * total price of the sale(including VAT)
     */
    public void newSale(double totalPrice);
}
