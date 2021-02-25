package com.earl.crystalbudget.crystalbudget.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.earl.crystalbudget.crystalbudget.entity.ETransaction;

/**
 * @author Earl
 * @version 1.0.0, 03 Feb 2021
 */
@Repository
public interface TransactionRepo  extends JpaRepository<ETransaction, Integer>{
		
	ETransaction findTopByOrderByBalIdDesc();
	
	
}
