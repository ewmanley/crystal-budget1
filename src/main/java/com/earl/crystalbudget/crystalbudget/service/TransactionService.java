package com.earl.crystalbudget.crystalbudget.service;

import com.earl.crystalbudget.crystalbudget.entity.ETransaction;

/**
 * @author Earl
 * @version 1.0.0, 05 Feb 2021
 */
public interface TransactionService {

	double getBalance();

	void transaction(ETransaction transaction);
}
