/**
 * 
 */
package org.rash.fastfood.checkout;

import java.util.List;

import org.rash.fastfood.items.Item;

/**
 * @author Rasool.Shaik
 *
 */
public interface ICartService {

	Cart addItemToCart(int userId, int itemId);

	List<Item> fetchItemsOfUser(int userId);

	void deleteAnItemInCart(int userId, int itemId);

	BillObject checkout(int userId, String couponName);

	List<Coupon> fetchCoupns();

}
