package com.earl.crystalbudget.crystalbudget.unittests.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.earl.crystalbudget.crystalbudget.repo.TransactionRepo;

@DataJpaTest
public class TransactionRepoTest {
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Test
	public void findTopByOrderByBalIdDescTest() {
		double actual = transactionRepo.findTopByOrderByBalIdDesc().getBalance();
		double expected = 1002.0;
		assertEquals(expected,actual);
	}

}
