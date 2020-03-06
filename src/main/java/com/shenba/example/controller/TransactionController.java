package com.shenba.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shenba.example.entity.Transaction;
import com.shenba.example.messaging.TransactionSender;
import com.shenba.example.service.TransactionService;

@RestController
@RequestMapping(path = "/rest/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionSender sender;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(value = "/{txId}")
	public Transaction getTransactionById(@PathVariable(name = "txId") Long txId) {
		return sender.getTransactionById(txId);
	}
	
	@PostMapping
	public Transaction saveTranasction(@RequestBody Transaction transaction) {
		return transactionService.save(transaction);
	}
	
	@GetMapping
	public List<Transaction> getTransactions() {
		return transactionService.getAll();
	}
	
}
