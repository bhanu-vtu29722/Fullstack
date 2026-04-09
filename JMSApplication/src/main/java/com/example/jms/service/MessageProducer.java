package com.example.jms.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

 @Autowired
 private JmsTemplate jmsTemplate;

 public void sendMessage(String message){
  jmsTemplate.convertAndSend("demoQueue", message);
 }

}
