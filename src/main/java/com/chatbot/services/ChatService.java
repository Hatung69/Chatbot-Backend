package com.chatbot.services;

import java.util.Date;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.model.MessageModel;

@Service
public class ChatService {
	
	@Autowired
	private Bot alice;
	@Autowired
	private Chat chatSession;
	
	public ChatService() {
	}
	
	public MessageModel response(String textAsk) {
		MessageModel messageModel = new MessageModel();
		try {
			messageModel.setContent(chatSession.multisentenceRespond(textAsk));
			messageModel.setTimestamp(new Date());
			System.out.println(chatSession.multisentenceRespond(textAsk));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return messageModel;
	}
}
