package com.spring.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	
	@Autowired
	Screen screen;
	@Autowired
	Camera camera;
	@Autowired
	Speaker speaker;
	
	public void tellSpec() {
		System.out.println("specs of myMobile");
		System.out.println("Screen size:" + screen.getLength() + " X " + screen.getBreadth() + "px");
	}
}
