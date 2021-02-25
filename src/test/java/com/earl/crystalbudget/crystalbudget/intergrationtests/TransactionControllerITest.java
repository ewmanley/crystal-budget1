package com.earl.crystalbudget.crystalbudget.intergrationtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.earl.crystalbudget.crystalbudget.entity.ETransaction;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TransactionControllerITest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getTransactionTest() {

		ETransaction transaction = new ETransaction();
		transaction.setTransactionAmount(100);
		transaction.setTransactionType("withdrawal");
		
		HttpEntity<ETransaction> request = new HttpEntity<>(transaction);
		
		ResponseEntity<?> response = testRestTemplate.
				  postForEntity("/transaction",request, String.class);
		
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

}