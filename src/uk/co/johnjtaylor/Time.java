package uk.co.johnjtaylor;

import java.util.TimerTask;
import java.util.Timer;

public class Time {
	private Long elapsed;
	private Timer scheduler = new Timer();
	private TimerTask increment;
	private boolean timerActive;
	
	public Time() {
		elapsed = 0L;
		timerActive = false;
	}
	
	public synchronized void start() {
		timerActive = true;
		increment = new TimerTask() {
			@Override
			public void run() {
				if(timerActive) {
					elapsed++;
				}
			}
		};
		scheduler.scheduleAtFixedRate(increment, 0L, 1L);
	}
	
	public synchronized void pause() {
		timerActive = false;
	}
	
	public synchronized void unpause() {
		timerActive = true;
	}
	
	public synchronized void stop() {
		pause();
	}
	
	public synchronized Long getTime() {
		return elapsed;
	}


}
