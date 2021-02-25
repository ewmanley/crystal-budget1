package com.earl.crystalbudget.crystalbudget.unittests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.earl.crystalbudget.crystalbudget.entity.ETransaction;
import com.earl.crystalbudget.crystalbudget.service.TransactionService;

import jdk.net.SocketFlow.Status;

@WebMvcTest
class TransactionControllerMvcUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TransactionService transactionServiceMock;
	
	@Test
	public void transactionTest() throws Exception {

        RequestBuilder request = post("/transaction").accept(MediaType.APPLICATION_JSON).content("{\"transactionAmount\":200,\"transactionType\":\"deposit\"}")
                .contentType(MediaType.APPLICATION_JSON);
        
        mvc.perform(request).andExpect(status().isOk()).andReturn();	
	}
}
