package se.kth.iv1350.pos.view;
import java.io.*;
import se.kth.iv1350.pos.model.SaleObserver;
/**
 * TotalRevenueFileOutput implements the interface SaleObserver.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue;
    private PrintWriter file;
    /**
     * Creates a new file with specified file name.
     */
    TotalRevenueFileOutput() {
        try{
           this.file = new PrintWriter(new FileWriter("revenue.txt"), true); 
        }catch(IOException exception){
           System.out.println("Could not create file");
        }
    }
    /**
     * Prints file with a specific String.
     * @param totalPrice receives the total price of the sale (including VAT)
     */
    @Override
    public void newSale(double totalPrice){
        this.totalRevenue += totalPrice;
        this.file.println("Total Revenue: " + this.totalRevenue);
    }
}
