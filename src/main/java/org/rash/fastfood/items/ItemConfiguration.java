/**
 * 
 */
package org.rash.fastfood.items;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * @author Rasool.Shaik
 *
 */
@Configuration
@EnableJpaRepositories("org.rash.fastfood")
@PropertySource("classpath:db-config.properties")
public class ItemConfiguration {

	protected Logger logger;

	public ItemConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	@Bean
	public DataSource dataSource() {

		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:schema.sql").addScript("classpath:data.sql").build();

		return dataSource;
	}

}
