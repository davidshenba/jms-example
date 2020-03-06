package com.shenba.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenba.example.entity.Transaction;
import com.shenba.example.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	public Transaction findById(Long transactionId) {
		log.info("Looking for transaction with ID: {}", transactionId);
		Optional<Transaction> transaction = transactionRepo.findById(transactionId);
		if(transaction.isPresent()) {
			log.info("Returning object: " + transaction.get().toString());
			return transaction.get();
		}
		return new Transaction();
	}
	
	public List<Transaction> getAll() {
		return transactionRepo.findAll();
	}
	
	public Transaction save(Transaction transaction) {
		log.info("Saving object: " + transaction.toString());
		return transactionRepo.save(transaction);
	}

}
