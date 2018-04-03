package au.com.tpg.profiling.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.com.tpg.profiling.service.Service;

/**
 * Sample of main class to demonstrate timing measure tool
 * 
 * @author Suhaimi Sulaiman
 */
public class Main {
	public static void main(String[] args) {

		// Create Spring application context that configured by xml.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		// Get our service from the spring context (that we want to be profiled).
		Service service = ctx.getBean(Service.class);

		// Test profiling through methods calls.

		// Calling randomSleepTime method which will sleep between 1000 ms to 3000 ms
		for (int i = 0; i < 10; i++) {
			service.randomSleepTime();
		}
		
		// Calling fixSleepTime method which will sleep for fixed 5000 ms
		service.fixSleepTime();

		// Close the spring context
		ctx.close();
	}
}
