/**
 * 
 */
package org.rash.fastfood.checkout;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.rash.fastfood.items.Item;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Rasool.Shaik
 *
 */
@Path("/cart")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CartResource {
	@Autowired
	private ICartService cartService;

	@POST
	@Path("/additem")
	public Cart addItemToCart(@QueryParam("userId") int userId, @QueryParam("itemId") int itemId) {
		return cartService.addItemToCart(userId, itemId);
	}

	@DELETE
	@Path("/deleteItem")
	public void deleteItemFromCart(@QueryParam("userId") int userId, @QueryParam("itemId") int itemId) {

		cartService.deleteAnItemInCart(userId, itemId);
	}

	@GET
	@Path("/items")
	public List<Item> fetchItemsOfUser(@QueryParam("userId") int userId) {
		return cartService.fetchItemsOfUser(userId);
	}

	@POST
	@Path("/checkout")
	public BillObject checkout(@QueryParam("userId") int userId, @QueryParam("couponName") String couponName) {
		return cartService.checkout(userId, couponName);
	}

	@GET
	@Path("/coupons")
	public List<Coupon> fetchAllCoupns() {
		return cartService.fetchCoupns();
	}

}
