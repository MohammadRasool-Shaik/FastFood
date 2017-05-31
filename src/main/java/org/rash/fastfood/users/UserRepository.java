/**
 * 
 */
package org.rash.fastfood.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rasool.Shaik
 *
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

}
