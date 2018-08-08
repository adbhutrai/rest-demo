package com.adbhut.event;

import org.springframework.context.ApplicationEvent;

import com.adbhut.model.Message;

public class EventReceivedListener extends ApplicationEvent {
	private static final long serialVersionUID = -3369542312816680334L;
	private Message message;

	public EventReceivedListener(Object source, Message message) {
		super(source);
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}
	
}