package com.earl.crystalbudget.crystalbudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earl.crystalbudget.crystalbudget.Configuration;
import com.earl.crystalbudget.crystalbudget.service.TransactionService;

/**
 * This controller object get the balance from the database
 * 
 * @author Earl
 * @version 1.0.0, 03 Feb 2021
 */
@RestController()
public class BalanceController { 
	
	Logger logger = LoggerFactory.getLogger(BalanceController.class);
	
//	@Autowired 
//	private Configuration configuration;
	
	@Autowired
	Configuration config = new Configuration();
	
	@Autowired
	private TransactionService transactionService;
	
	/**
	 * Method call to return a persons balance
	 * @return The amount in the current persons balance
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/balance")
	public ResponseEntity<?> getCurrentBalance(){
		config.getMaximum();
		double response = transactionService.getBalance();
		logger.info("BalanceController : getCurrentBalance : Balance received: {}",  response);
		return ResponseEntity.ok().body(response);		
	}
	
	@GetMapping("/test")
	public int test(){
		return config.getMaximum();
	}
		
}
