package com.earl.crystalbudget.crystalbudget.unittests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.earl.crystalbudget.crystalbudget.controller.BalanceController;
import com.earl.crystalbudget.crystalbudget.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class BalanceControllerUnitTest {
	
	@InjectMocks
	BalanceController balanceController;
	
	@Mock
	private TransactionService transactionServiceMock;
	
	@Test
	public void getCurrentBalanceUnitTest() {
		when(transactionServiceMock.getBalance()).thenReturn(1000.0);
		ResponseEntity<?> actual = balanceController.getCurrentBalance();
		assertEquals("1000.0", actual.getBody().toString());
	}
}
