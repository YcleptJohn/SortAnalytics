package uk.co.johnjtaylor;

import java.util.TimerTask;
import java.util.Timer;

public class Time {
	private Long elapsed;
	private Timer scheduler = new Timer();
	private TimerTask increment;
	
	public Time() {
		elapsed = 0L;
	}
	
	public synchronized void start() {
		increment = new TimerTask() {
			@Override
			public void run() {
				elapsed++;
			}
		};
		scheduler.scheduleAtFixedRate(increment, 0L, 1L);
	}
	
	public synchronized void pause() {
		stop();
	}
	
	public synchronized void unpause() {
		start();
	}
	
	public synchronized void stop() {
		increment.cancel();
	}
	
	public synchronized Long getTime() {
		return elapsed;
	}


}
