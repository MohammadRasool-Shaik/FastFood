/**
 * 
 */
package org.rash.fastfood.checkout;

import java.io.Serializable;
import java.util.List;

import org.rash.fastfood.items.Item;

/**
 * @author Rasool.Shaik
 *
 */
public class BillObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private int noOfItems;
	private List<Item> items;
	private double totalCartValue;
	private double discountObtained;
	private double totalPayable;
	private String message;

	/**
	 * @return the noOfItems
	 */
	public int getNoOfItems() {
		return noOfItems;
	}

	/**
	 * @param noOfItems
	 *            the noOfItems to set
	 */
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	/**
	 * @return the totalPayable
	 */
	public double getTotalPayable() {
		return totalPayable;
	}

	/**
	 * @param totalPayable
	 *            the totalPayable to set
	 */
	public void setTotalPayable(double totalPayable) {
		this.totalPayable = totalPayable;
	}

	/**
	 * @return the discountObtained
	 */
	public double getDiscountObtained() {
		return discountObtained;
	}

	/**
	 * @param discountObtained
	 *            the discountObtained to set
	 */
	public void setDiscountObtained(double discountObtained) {
		this.discountObtained = discountObtained;
	}

	/**
	 * @return the totalCartValue
	 */
	public double getTotalCartValue() {
		return totalCartValue;
	}

	/**
	 * @param totalCartValue
	 *            the totalCartValue to set
	 */
	public void setTotalCartValue(double totalCartValue) {
		this.totalCartValue = totalCartValue;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BillObject [noOfItems=" + noOfItems + ", items=" + items + ", totalCartValue=" + totalCartValue + ", discountObtained=" + discountObtained + ", totalPayable="
				+ totalPayable + "]";
	}

}
