package ra.ac.bg.etf.kdp.cas;

import java.util.*;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread{
	private final int consumers;
	private AtomicInteger[] buffer;
	private AtomicInteger[][] reads;
	private Semaphore mutex;
	private int b;
	
	public Producer(int consumers,AtomicInteger[]bfer,AtomicInteger[][] reads,int bb, Semaphore m) {
		this.consumers=consumers;
		this.buffer=bfer;
		this.reads=reads;
		this.b=bb;
		this.mutex=m;
	}
	@Override
	public void run() {
		for(int i=0;i<b;i++) {
			for(int j=0;j<consumers;j++) {
				while(reads[i][j].get()==1) {
					Thread.onSpinWait();
				}
				int rand=(int) (Math.random()*10);
				System.out.println("Producer produced element: " + rand );
				mutex.acquireUninterruptibly();
				buffer[i].set(rand);
				mutex.release();
				
				mutex.acquireUninterruptibly();
				for (int j2 = 0; j2 < consumers; j2++)
					reads[i][j2].set(0);
				mutex.release();
			}
		}
	}
	

}
