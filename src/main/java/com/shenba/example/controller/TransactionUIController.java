package com.shenba.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/transactions")
public class TransactionUIController {

	@GetMapping
	public String showTransactions() {
		return "html/transactions.html";
	}
	
}
