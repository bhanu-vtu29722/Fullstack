package com.example.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.jms.service.MessageProducer;

@RestController
public class MessageController {

 @Autowired
 private MessageProducer producer;

 @GetMapping("/send")
 public String sendMessage(){
  producer.sendMessage("Hello Students! JMS Message Sent");
  return "Message Sent Successfully";
 }

}
