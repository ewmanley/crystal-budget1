package com.earl.crystalbudget.crystalbudget.intergrationtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class BalanceControllerITest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getBalanceTest() throws JSONException {

		
		ResponseEntity<String> response = testRestTemplate.
				  getForEntity("/balance", String.class);
		
		assertEquals(response.getStatusCode(),HttpStatus.OK);
		assertEquals(response.getBody(),"1002.0");
	}

}
