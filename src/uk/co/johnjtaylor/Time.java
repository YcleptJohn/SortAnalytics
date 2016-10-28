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
	
	public void start() {
		increment = new TimerTask() {
			@Override
			public void run() {
				elapsed++;
			}
		};
		scheduler.scheduleAtFixedRate(increment, 0L, 1L);
	}
	
	public void pause() {
		stop();
	}
	
	public void unpause() {
		start();
	}
	
	public void stop() {
		increment.cancel();
	}
	
	public Long getTime() {
		return elapsed;
	}


}
