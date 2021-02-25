package com.earl.crystalbudget.crystalbudget.doa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earl.crystalbudget.crystalbudget.entity.ETransaction;
import com.earl.crystalbudget.crystalbudget.repo.TransactionRepo;

/**
 * This object is where interaction with the database will take place 
 * 
 * @author Earl
 * @version 1.0.0, 03 Feb 2021
 */
@Service
public class Transactions implements ITransactions{
	
	Logger logger = LoggerFactory.getLogger(Transactions.class);
		
	@Autowired
	TransactionRepo transactionRepo;

	/**
	 * Enters deposit or withdrawal transaction
     * @param eTransaction an object with the transaction type and transaction amount
     */
	public void enterTransactionRecord(ETransaction eTransaction) {
		try {
			transactionRepo.save(eTransaction);	
		} catch(NullPointerException e) {
			logger.error("Transactions : enterTransactionRecord : DB persistence was not successfull enter value: {}" , e);
			throw new NullPointerException();
		}
		
		logger.info("Transactions : enterTransactionRecord : Transaction entered DB successfully:");
		
	}


	/**
	 * Get account balance 
	 * @return the current balance
	 */
	public double getBalanceRecord() {
		double balanceRecord = 0;
		try {
			balanceRecord = transactionRepo.findTopByOrderByBalIdDesc().getBalance();	
		} catch(NullPointerException e) {
			logger.error("Transactions : getBalanceRecord : DB persistence was not successfull returned value: " + e);
			throw new NullPointerException();
		}
		
		logger.info("Transactions : getBalanceRecord : Retreived from DB successfully: {} ",  balanceRecord);
		
		return balanceRecord;
	}
}
