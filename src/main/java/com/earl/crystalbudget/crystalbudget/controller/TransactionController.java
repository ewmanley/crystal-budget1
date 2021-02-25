package com.earl.crystalbudget.crystalbudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.earl.crystalbudget.crystalbudget.entity.ETransaction;
import com.earl.crystalbudget.crystalbudget.service.TransactionService;

/**
 * This controller object either deposits or withdrawal from the database
 * 
 * @author Earl
 * @version 1.0.0, 03 Feb 2021
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	private TransactionService transactionService;

	
    /**
     * @param transaction  and object with the transaction type and transaction amount
     */
    @PostMapping("transaction")
    @ResponseStatus(value = HttpStatus.OK)
    public void transaction(@RequestBody ETransaction transaction){
    	logger.info("TransactionController : transaction : Transaction records: amount = {}, type = {}",  transaction.getTransactionAmount(), transaction.getTransactionType());
    	transactionService.transaction(transaction);
    }   
}
