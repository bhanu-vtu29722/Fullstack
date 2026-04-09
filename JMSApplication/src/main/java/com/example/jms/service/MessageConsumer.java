package com.example.jms.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

 @JmsListener(destination = "demoQueue")
 public void receiveMessage(String message){
  System.out.println("Received Message: " + message);
 }

}

