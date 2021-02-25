package com.earl.crystalbudget.crystalbudget.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Earl
 * @version 1.0.0, 03 Feb 2021
 */
@Entity
@Table(name="balance_table")
public class ETransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int balId;
	private double transactionAmount;
	private double balance;	
	private String transactionType;
	private LocalDate localDate = LocalDate.now();

	/**
	 * @param transactionType the type of transaction (deposit or withdrawal)
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	/**
	 * @return 
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @return ID of the balance
	 */
	public int getBalId() {
		return balId;
	}

	/**
	 * @param balId  the balance ID
	 */
	public void setBalId(int balId) {
		this.balId = balId;
	}

	/**
	 * @return current date
	 */
	public LocalDate getLocalDate() {
		return localDate;
	}

	/**
	 * @param localDate  current date
	 */
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	/**
	 * @return amount to be withdrawn or deposited
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}
	
	/**
	 * @param transactionAmount amount to be withdrawn or deposited
	 */
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance current balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
