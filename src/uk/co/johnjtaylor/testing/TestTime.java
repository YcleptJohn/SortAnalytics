package uk.co.johnjtaylor.testing;

import org.junit.Test;

import uk.co.johnjtaylor.Time;

public class TestTime {
	
	
	@Test
	public void testConstructor() {
		assert(new Time().getTime() == 0L);
	}
	
	@Test
	public void testStart() throws InterruptedException {
		Time timer = new Time();
		timer.start();
		Thread.sleep(20);
		assert(timer.getTime() > 0L);
	}
	
	@Test
	public void testPause() throws InterruptedException {
		Time timer = new Time();
		timer.start();
		Thread.sleep(10);
		timer.pause();
		Long pausedTime = timer.getTime();
		Thread.sleep(30);
		assert(pausedTime.equals(timer.getTime()));
	}
	
	@Test
	public void testUnpause() throws InterruptedException {
		Time timer = new Time();
		timer.start();
		Thread.sleep(10);
		timer.pause();
		Long pausedTime = timer.getTime();
		timer.unpause();
		Thread.sleep(30);
		assert(!(pausedTime.equals(timer.getTime())));
	}
}
