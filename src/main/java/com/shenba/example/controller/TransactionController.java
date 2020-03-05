package com.shenba.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shenba.example.entity.Transaction;
import com.shenba.example.messaging.TransactionSender;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionSender sender;
	
	@GetMapping(value = "/{txId}")
	public Transaction getTransactionById(@PathVariable(name = "txId") Long txId) {
		return sender.getTransactionById(txId);
	}
	
}
