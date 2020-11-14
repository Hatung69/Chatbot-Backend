package com.chatbot.config;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.configuration.BotConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
	@Bean
	public Bot alice() {
		return new Bot(BotConfiguration.builder().name("alice").path("src/main/resources").build());
	}
	
	@Bean
	public Chat chatSession() {
		return new Chat(alice());
	}
}
