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
	@Autowired
	private String textAskTemp;// Biến string tạm để Check bên dưới 
	
	public ChatService() {
	}
	
	public MessageModel response(String textAsk) {
		/*
		 * Check xem nếu request lên giống request trước thì tạo session mới, nếu không
		 * thì cái session cũ nó sẽ respond ko đúng, đéo hiểu sao !
		 */
		if (textAskTemp.equals(textAsk)) {
			chatSession=new Chat(alice);
		}
		MessageModel messageModel = new MessageModel();
		try {
			textAskTemp=textAsk;// Set biến String tạm = request để request tiếp còn Check :v
			messageModel.setContent(chatSession.multisentenceRespond(textAsk));
			messageModel.setTimestamp(new Date());
			System.out.println(chatSession.multisentenceRespond(textAsk));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return messageModel;
	}
}
