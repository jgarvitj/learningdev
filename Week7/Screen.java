package com.spring.first;

import org.springframework.stereotype.Component;

@Component
public class Screen {

	private int length = 24;
	private int breadth = 18;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
}
