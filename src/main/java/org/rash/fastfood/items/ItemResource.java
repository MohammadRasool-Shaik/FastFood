/**
 * 
 */
package org.rash.fastfood.items;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Rasool.Shaik
 *
 */
@Path("/items")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ItemResource {

	protected Logger logger = Logger.getLogger(ItemResource.class.getName());
	@Autowired
	protected ItemRepository itemRepository;

	@GET
	public List<Item> fetchAllItems() {
		return itemRepository.findAll();
	}

	@GET
	@Path("/{itemId}")
	public Item fetchByItemId(@PathParam("itemId") Integer itemId) {
		return itemRepository.findByItemId(itemId);
	}

	public List<Item> fetchByItemPrice(@QueryParam("lowPrice") Double lowPrice, @QueryParam("highPrice") Double highPrice) {
		return itemRepository.findByItemPrice(lowPrice, highPrice);
	}

	public List<Item> fetchByItemType(@QueryParam("type") String type) {
		return itemRepository.findByItemType(type);
	}

	public List<Item> fetchByItemName(@QueryParam("name") String name) {
		return itemRepository.findByItemNameIgnoreCase(name);
	}

	public List<Item> fetchProductsByNamePrice(@QueryParam("name") String name, @QueryParam("price") Double price) {
		return itemRepository.findByItemNamePrice(name, price);
	}

	@POST
	public Item createProduct(Item item) {
		return itemRepository.save(item);
	}

	@Path("/{itemId}")
	@DELETE
	public Integer removeItem(@PathParam("itemId") Integer itemId) {
		return itemRepository.removeByItemId(itemId);
	}
}
