package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.model.SaleObserver;
/**
 * TotalRevenueView implements the interface SaleObserver.
 */
class TotalRevenueView implements SaleObserver {
    private double totalRevenue;
    
    /**
     * Prints a specific String to console.
    * @param totalPrice receives the total price of the sale (including VAT)
    */
    @Override
    public void newSale(double totalPrice){
        totalRevenue += totalPrice;
        System.out.println("Total revenue: " + totalRevenue);
    }
}
