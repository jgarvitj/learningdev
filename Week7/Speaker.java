package com.spring.first;

import org.springframework.stereotype.Component;

@Component
public class Speaker {

	private String typeOfSpeaker;
	private int volLevel;
	
	public String getTypeOfSpeaker() {
		return typeOfSpeaker;
	}
	public void setTypeOfSpeaker(String typeOfSpeaker) {
		this.typeOfSpeaker = typeOfSpeaker;
	}
	public int getVolLevel() {
		return volLevel;
	}
	public void setVolLevel(int volLevel) {
		this.volLevel = volLevel;
	}
}
