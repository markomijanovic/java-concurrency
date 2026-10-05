package ra.ac.bg.etf.kdp.cas;

import java.util.concurrent.locks.*;
public class SemaphoreKDP {
	private int s = 0;
	Lock lock=new ReentrantLock(true);
	
	public SemaphoreKDP(int init) {
		this.s=init;
	}
	
	public synchronized void semWait() {
		while(s==0) {
			try{
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		s--;
	}
	
	public synchronized void semSignal() {
		s++;
		notify();
	}
	public boolean work() {
		System.out.println("ajmoo");
		return true;
	}
	
	public boolean criticalSection() {
		boolean locked=false;
		try {
			locked=lock.tryLock();
			if(locked) {work();}
			
		}finally {
			if(locked) lock.unlock();
		}
		return locked;
		
	}
	public static void main(String[] args) {
		
	} 
}