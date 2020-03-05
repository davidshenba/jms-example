package com.shenba.example.messaging;

import java.util.Arrays;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class TransactionMQConfiguration {
	
	private static final String BROKER_URL = "tcp://localhost:61616";
    
    public static final String TX_REQ_QUEUE = "transaction-request-queue";
    public static final String TX_RESP_QUEUE = "transaction-response-queue";
    
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(BROKER_URL);
        connectionFactory.setTrustAllPackages(true);
        return connectionFactory;
    }
    
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(TX_REQ_QUEUE);
        return template;
    }

}
