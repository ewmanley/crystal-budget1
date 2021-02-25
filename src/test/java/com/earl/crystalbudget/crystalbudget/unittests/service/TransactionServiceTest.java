package com.earl.crystalbudget.crystalbudget.unittests.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.earl.crystalbudget.crystalbudget.doa.ITransactions;
import com.earl.crystalbudget.crystalbudget.doa.Transactions;
import com.earl.crystalbudget.crystalbudget.entity.ETransaction;
import com.earl.crystalbudget.crystalbudget.service.TransactionServiceImpl;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
	
	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	
	@Mock
	ITransactions iTransactionsMock;
	
	@Mock
	ETransaction eTransactionMock;
	
	ETransaction transaction = new ETransaction();
	
	private ETransaction getMTrasaction() {
		transaction.setTransactionAmount(1000);
		return transaction;
		
	}
	
	@Test
	void depositTest() {
		when(iTransactionsMock.getBalanceRecord()).thenReturn(1000.0);
		transaction.setTransactionType("widthdrawal");
		transactionServiceImpl.transaction(getMTrasaction());
	}
	
	@Test
	void WidthdrawelTest() {
		when(iTransactionsMock.getBalanceRecord()).thenReturn(1000.0);
		transaction.setTransactionType("deposit");
		transactionServiceImpl.transaction(getMTrasaction());
	}
	

	@Test
	void getBalanceTest() {
		when(iTransactionsMock.getBalanceRecord()).thenReturn(6.0);
		double actual = transactionServiceImpl.getBalance();
		double expected = 6;
		assertEquals(expected,actual); 
	}

}
