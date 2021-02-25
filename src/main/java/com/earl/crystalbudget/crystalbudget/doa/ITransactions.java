package com.earl.crystalbudget.crystalbudget.doa;

import com.earl.crystalbudget.crystalbudget.entity.ETransaction;

/**
 * This controller object either deposits or withdrawal from the database
 * 
 * @author Earl
 * @version 1.0.0, 03 Feb 2021
 */
public interface ITransactions {
	public void enterTransactionRecord(ETransaction eTransaction);
	public double getBalanceRecord();

}
