package com.chatbot.model;

import java.util.Date;

public class MessageModel {
	private String content;
	private Date timestamp;

	//----------------------
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	//----------------------
	public MessageModel(String content, Date timestamp) {
		super();
		this.content = content;
		this.timestamp = timestamp;
	}

	public MessageModel() {
	}
}
