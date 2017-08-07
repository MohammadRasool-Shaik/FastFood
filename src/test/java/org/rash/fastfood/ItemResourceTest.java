package org.rash.fastfood;

import javax.ws.rs.core.MediaType;

import org.hamcrest.CoreMatchers;
//import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

/**
 * @author Rasool.Shaik
 *
 */
public class ItemResourceTest extends FunctionalTest {

	@Test
	public void getItems() {
		RestAssured.given().contentType(MediaType.APPLICATION_JSON )
		.when().get("/items")
		.then().log().ifError().statusCode(200).body(CoreMatchers.containsString("Veg"));
	}
}
