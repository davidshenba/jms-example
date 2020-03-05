package com.shenba.example.messaging;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class TransactionMQListernerConfiguration {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory jmsFactory = new DefaultJmsListenerContainerFactory();
        jmsFactory.setConnectionFactory(connectionFactory);
        jmsFactory.setConcurrency("2-9");
        return jmsFactory;
    }

}
