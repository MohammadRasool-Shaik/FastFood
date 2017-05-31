/**
 * 
 */
package org.rash.fastfood.items;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rasool.Shaik
 *
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7335576478725557679L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Integer itemId;

	@Column(nullable = false, length = 50)
	private String itemName;

	@Column(nullable = false, length = 10)
	private String itemType;

	@Column(nullable = false, scale = 2)
	private Double itemPrice;

	/**
	 * @param itemName
	 * @param itemType
	 * @param itemPrice
	 * @param quantity
	 */
	public Item(String itemName, String itemType, Double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
	}

	/**
	 * 
	 */
	public Item() {
		super();
	}

	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType
	 *            the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the itemPrice
	 */
	public Double getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice=" + itemPrice + "]";
	}

}
