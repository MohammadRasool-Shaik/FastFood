/**
 * 
 */
package org.rash.fastfood.checkout;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Rasool.Shaik
 *
 */
@Entity
public class Coupon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1912866651360446707L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupon_id")
	private Integer id;

	private String couponName;
	private Double discount;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the couponName
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * @param couponName
	 *            the couponName to set
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
