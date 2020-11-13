package com.chatbot.services;

import java.util.Date;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.model.MessageModel;

@Service
public class ChatService {
	
	private Chat chatSession;
	@Autowired
	private Bot alice;
	
	public MessageModel response(String textAsk) {
		MessageModel messageModel = new MessageModel();
		chatSession = new Chat(alice);
		try {
			messageModel.setContent(chatSession.multisentenceRespond(textAsk));
			messageModel.setTimestamp(new Date());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return messageModel;
	}
}