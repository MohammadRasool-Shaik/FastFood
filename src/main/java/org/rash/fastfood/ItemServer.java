/**
 * 
 */
package org.rash.fastfood;

import org.rash.fastfood.items.ItemConfiguration;
import org.rash.fastfood.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Rasool.Shaik
 *
 */
@SpringBootApplication
@Import(ItemConfiguration.class)
public class ItemServer {

	@Autowired
	protected ItemRepository itemRepository;

	public static void main(String[] args) {

		SpringApplication.run(ItemServer.class, args);
	}
}
