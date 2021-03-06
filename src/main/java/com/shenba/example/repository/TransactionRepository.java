package com.shenba.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shenba.example.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
	List<Transaction> findAll();
}
