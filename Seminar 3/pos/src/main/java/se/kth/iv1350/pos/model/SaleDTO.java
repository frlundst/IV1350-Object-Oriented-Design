package se.kth.iv1350.pos.model;

import java.util.*;
import java.time.*;

/**
 * SaleDTO, Sale data transfer object. Groups variables related to a sale.
 */
public class SaleDTO {
	private java.time.LocalTime time;
	private String nameOfStore = "Gittans Livs";
	private double totalVAT;
	private double totalPrice;
	private List<Item> items;

	/**
	 * Creates an instance of SaleDTO.
	 * @param time Holds the current time of the sale
	 * @param nameOfStore Holds Name of the store
	 * @param totalVAT Holds the total VAT
	 * @param totalPrice Holds the total Price
	 * @param items Holds the current Sale Items
	 */
	public SaleDTO(java.time.LocalTime time, double totalVAT,
			double totalPrice, List<Item> items) {
		this.time = time;
		this.nameOfStore = nameOfStore;
		this.totalVAT = totalVAT;
		this.totalPrice = totalPrice;
		this.items = items;
	}

	/**
     * Returns the localtime.
     * @return time returns the local time.
     */
	public java.time.LocalTime getTime() {
		return this.time;
	}

	/**
     * Returns the name of the store.
     * @return nameOfStore
     */
	public String getNameOfStore() {
		return this.nameOfStore;
	}

	/**
	 * Return total VAT of the sale
	 * @return totalVAT, holds the total VAT for the sale
	 */
	public double getTotalVAT() {
		return this.totalVAT;
	}

	/**
	 * Returns the total Price of the sale
	 * @return totalPrice, holds the total Price of the Sale
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * Returns a list of items in the current sale
	 * @return items, holds the current Sale items
	 */
	public List<Item> getItems() {
		return this.items;
	}
}
