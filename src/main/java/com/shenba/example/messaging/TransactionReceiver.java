package com.shenba.example.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.shenba.example.entity.Transaction;
import com.shenba.example.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TransactionReceiver {
	

	@Autowired
	private TransactionService transactionService;
	
	@JmsListener(destination = TransactionMQConfiguration.TX_REQ_QUEUE)
	@SendTo(value = TransactionMQConfiguration.TX_RESP_QUEUE)
    public Transaction getTransactionById(final Message<Long> transctionID) {
        log.info("Request received in MQ for Transaction id: " + transctionID);
        return transactionService.findById(transctionID.getPayload());
    }

}
