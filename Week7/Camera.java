package com.spring.first;

import org.springframework.stereotype.Component;

@Component
public class Camera {
	
	private int number_mgPixels;

	public int getNumber_mgPixels() {
		return number_mgPixels;
	}

	public void setNumber_mgPixels(int number_mgPixels) {
		this.number_mgPixels = number_mgPixels;
	}

}
