/**
 * 
 */
package org.rash.fastfood.checkout;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.rash.fastfood.items.Item;
import org.rash.fastfood.items.ItemRepository;
import org.rash.fastfood.users.User;
import org.rash.fastfood.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rasool.Shaik
 *
 */
@Service("cartService")
public class CartService implements ICartService {
	@Autowired
	protected CartRepository cartRepository;

	@Autowired
	protected ItemRepository itemRepository;

	@Autowired
	protected EmailService emailService;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Cart addItemToCart(int userId, int itemId) {
		return cartRepository.save(new Cart(userId, itemId));
	}

	@Override
	public List<Item> fetchItemsOfUser(int userId) {
		List<Cart> cartItems = cartRepository.findByUserId(userId);
		List<Integer> itemIds = cartItems.stream().map(t -> t.getCartId()).collect(Collectors.toList());
		return (List<Item>) itemRepository.findAll(itemIds);
	}

	@Override
	public BillObject checkout(int userId, String couponName) {
		List<Item> items = fetchItemsOfUser(userId);

		List<Coupon> coupons = cartRepository.fetchAllCoupns();

		items.stream().forEach(item -> deleteAnItemInCart(userId, item.getItemId()));
		BillObject billObject = calculateBill(couponName, items, coupons);

		User user = userRepository.findOne(userId);
		emailService.sendMail(user.getEmail(), "Mr. " + user.getUserName() + " CartInfo", billObject.toString());
		billObject.setMessage("Your cart information has been sent to " + user.getEmail());
		return billObject;
	}

	private BillObject calculateBill(String couponName, List<Item> items, List<Coupon> coupons) {
		BillObject billObject = new BillObject();
		billObject.setNoOfItems(items.size());
		billObject.setItems(items);
		double sum = items.stream().map(item -> item.getItemPrice()).mapToDouble(Double::valueOf).sum();
		billObject.setTotalCartValue(sum);

		Optional<Coupon> isCoupon = coupons.stream().filter(coupon -> coupon.getCouponName().equals(couponName)).findFirst();
		double dicountedAmount = 0;
		if (isCoupon.isPresent()) {
			dicountedAmount = sum * ((isCoupon.get().getDiscount()) / 100);
		}
		billObject.setDiscountObtained(dicountedAmount);
		billObject.setTotalPayable(sum - dicountedAmount);
		return billObject;
	}

	@Override
	public List<Coupon> fetchCoupns() {
		return cartRepository.fetchAllCoupns();
	}

	@Override
	public void deleteAnItemInCart(int userId, int itemId) {
		cartRepository.deleteAnItemFromCart(userId, itemId);
	}

}
