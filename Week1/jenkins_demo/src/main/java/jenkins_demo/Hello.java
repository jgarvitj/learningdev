package jenkins_demo;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Hello {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm::ss");
		LocalDateTime now = LocalDateTime.now();
	
		System.out.println("Hello world executed at "
				+ "" + dtf.format(now));
	}

}
