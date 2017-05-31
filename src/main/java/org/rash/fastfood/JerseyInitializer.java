/**
 * 
 */
package org.rash.fastfood;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rasool.Shaik
 *
 */
@Configuration
public class JerseyInitializer extends ResourceConfig {
	public JerseyInitializer() {
		this.packages("org.rash.fastfood");
	}
}
