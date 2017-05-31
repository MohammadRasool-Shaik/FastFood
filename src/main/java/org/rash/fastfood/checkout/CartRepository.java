/**
 * 
 */
package org.rash.fastfood.checkout;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rasool.Shaik
 *
 */
@Transactional
public interface CartRepository extends CrudRepository<Cart, Integer> {

	List<Cart> findByUserId(Integer userId);

	@SuppressWarnings("unchecked")
	Cart save(Cart cart);

	@Modifying
	@Query("DELETE FROM Cart c WHERE c.userId=:userId AND c.itemId=:itemId")
	void deleteAnItemFromCart(@Param("userId") Integer userId,@Param("itemId") Integer itemId);
	
	@Query("FROM Coupon")
	List<Coupon> fetchAllCoupns();
}
