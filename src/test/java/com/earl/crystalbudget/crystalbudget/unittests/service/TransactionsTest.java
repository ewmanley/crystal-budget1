package com.earl.crystalbudget.crystalbudget.unittests.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpServerErrorException;

import com.earl.crystalbudget.crystalbudget.doa.Transactions;
import com.earl.crystalbudget.crystalbudget.entity.ETransaction;
import com.earl.crystalbudget.crystalbudget.repo.TransactionRepo;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TransactionsTest {
	
	@InjectMocks
	Transactions transactions;
	
	@Mock
	TransactionRepo transactionRepoMock;
		
	private ETransaction getEtransaction() {
		ETransaction eTransaction  = new ETransaction();
		eTransaction.setBalance(1000);
		eTransaction.setTransactionAmount(0);
		eTransaction.setTransactionType("deposit");		
		return eTransaction;
	}
	
	@Test
	void makeTransactionTest() {
		ETransaction eTransaction = getEtransaction();
		transactions.enterTransactionRecord(eTransaction);
		ArgumentCaptor<ETransaction> captor = ArgumentCaptor.forClass(ETransaction.class);
		verify(transactionRepoMock).save(captor.capture());
		double expected = eTransaction.getBalance();
		double actual = captor.getValue().getBalance();
		assertEquals(expected,actual);
	}
	
	@Test
	void getBalanceRecordTest() {
		
		when(transactionRepoMock.findTopByOrderByBalIdDesc()).thenReturn(getEtransaction());
		double actual = transactions.getBalanceRecord();
		double expected = 1000.0;
		assertEquals(expected,actual);
	}
	
	@Test
	void whenDatabaseIsNotWorkThrowsHttpServerErrorExceptionOnGetBalanceRecordTest() {
		
		when(transactionRepoMock.findTopByOrderByBalIdDesc()).thenThrow(HttpServerErrorException.class);
		assertThrows(HttpServerErrorException.class, () -> {transactions.getBalanceRecord();});
	}
}
