package com.shenba.example.messaging;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.shenba.example.entity.Transaction;

@Component
public class TransactionSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public Transaction getTransactionById(Long transactionId) {
		final String correlationId = UUID.randomUUID().toString();
		jmsTemplate.convertAndSend(transactionId, new CorrelationIdPostProcessor(correlationId));
		Transaction transaction = (Transaction) jmsTemplate.receiveSelectedAndConvert(TransactionMQConfiguration.TX_RESP_QUEUE,
						"JMSCorrelationID='" + correlationId + "'");
		return transaction;
	}

}
