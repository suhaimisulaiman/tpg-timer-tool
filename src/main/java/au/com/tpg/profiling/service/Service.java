package au.com.tpg.profiling.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Service {

	public void randomSleepTime() {
		Random r = new Random();
		int sleepTime = r.ints(1000, (3000 + 1)).findFirst().getAsInt();
		System.out.println("Random Sleep Time is " + sleepTime);
		sleep(sleepTime);
	}

	public void fixSleepTime() {
		System.out.println("The program will sleep in 5000 ms...");
		sleep(5000);
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
