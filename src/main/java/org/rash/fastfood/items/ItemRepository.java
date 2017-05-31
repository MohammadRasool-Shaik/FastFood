/**
 * 
 */
package org.rash.fastfood.items;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rasool.Shaik
 *
 */
@Transactional
public interface ItemRepository extends CrudRepository<Item, Integer> {

	List<Item> findAll();

	Item findByItemId(Integer id);

	@SuppressWarnings("unchecked")
	Item save(Item item);

	Item findOne(Integer id);

	int removeByItemId(Integer id);

	void delete(Integer id);

	List<Item> findByItemType(String itype);

	List<Item> findByItemNameIgnoreCase(String name);

	@Query("FROM Item i WHERE i.itemPrice BETWEEN :lowPrice AND :highPrice")
	List<Item> findByItemPrice(@Param("lowPrice") Double lowPrice, @Param("highPrice") Double highPrice);

	@Query("FROM Item i WHERE i.itemName=:itemName AND i.itemPrice in (:price)")
	List<Item> findByItemNamePrice(@Param("itemName") String itemName, @Param("price") Double price);

	@Query("SELECT count(*) from Item")
	public int countItems();
}
