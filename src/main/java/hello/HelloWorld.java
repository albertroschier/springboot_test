package hello;

import java.time.LocalDateTime;

public class HelloWorld {
	public static void main(String[] args) {
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
	}
}