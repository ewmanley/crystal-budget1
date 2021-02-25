package com.earl.crystalbudget.crystalbudget.unittests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.earl.crystalbudget.crystalbudget.service.TransactionService;

@WebMvcTest
class BalanceControllerMvcUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TransactionService transactionServiceMock;
	
	@Test
	public void getCurrentBalanceUnitTest() throws Exception {
			when(transactionServiceMock.getBalance()).thenReturn(1000.0);
	        RequestBuilder request = get("/balance");
	        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
	        assertEquals("1000.0", result.getResponse().getContentAsString());
	}
}
