package ra.ac.bg.etf.kdp.cas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class clock implements Runnable {
	private volatile Thread thread=null;
	
	public void start() {
		if(thread==null) {
			thread=new Thread(this,"clock");
			thread.start();
		}
	}
	
	public void run() {
		Thread myThread=Thread.currentThread();
		while(thread==myThread) {
			paint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("interupted");
			}
		}
	}
	
	public void paint() {
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		DateFormat dateFormater=DateFormat.getTimeInstance();
		System.out.println(dateFormater.format(date));
		
	}
	
	public void stop() {
		Thread stopThread =thread;
		thread=null;
		stopThread.interrupt();
	}
}
