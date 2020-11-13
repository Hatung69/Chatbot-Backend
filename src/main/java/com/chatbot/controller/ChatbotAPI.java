package com.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.model.MessageModel;
import com.chatbot.services.ChatService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ChatbotAPI {
	
	@Autowired
	private ChatService chatService;
	
	@PostMapping("/chat-api/v1/messages")
	public MessageModel getResponse(@RequestBody String textAsk) {
		return chatService.response(textAsk);
	}
	
	@GetMapping("/")
	public String greating() {
		return "Hello World !";
	}
}
