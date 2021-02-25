package com.earl.crystalbudget.crystalbudget.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earl.crystalbudget.crystalbudget.controller.BalanceController;
import com.earl.crystalbudget.crystalbudget.doa.ITransactions;
import com.earl.crystalbudget.crystalbudget.entity.ETransaction;

/**
 *<p>
 *This is TransactionServiceImpl object the main 
 *@author Earl Manley Jr
 *@version 1.0.0, 02 Feb 2021
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	ITransactions iTransactions;
	
	@Override
	public void transaction(ETransaction transaction) {
		double balance = getBalance();
		double transAmount = transaction.getTransactionAmount();
		if(transaction.getTransactionType().equals("deposit")) {
			transaction.setBalance(balance + transAmount);
		} else if(transaction.getTransactionType().equals("withdrawal")) {
			transaction.setBalance(balance - transAmount);
		}
		logger.info("TransactionServiceImpl : transaction : Transaction records: amount = {}, type = {}",  transaction.getTransactionAmount(), transaction.getTransactionType());
		sendTransaction(transaction);
	}
	
	/**
	 *<p>
	 *This method calls the Date Access Object (DAO) layer to get the latest balance record
	 *</p>
	 *
	 *@return latest balance
	 */
	public double getBalance() {
		double latestBal = iTransactions.getBalanceRecord();
		logger.info("TransactionServiceImpl : getBalance : Balance record received: {}",  latestBal);
		return latestBal;
	}
	
	private void sendTransaction(ETransaction eTransaction) {
		iTransactions.enterTransactionRecord(eTransaction);	
	}
}
