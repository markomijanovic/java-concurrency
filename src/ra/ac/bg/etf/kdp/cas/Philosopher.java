package ra.ac.bg.etf.kdp.cas;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
	int id;
	int firstodd,secondeven;
	Semaphore [] fork;
	
	public Philosopher(int i,int n,Semaphore[] fork) {
		id=i;
		this.fork=fork;
		if(i%2==1) {
			firstodd=i;
			secondeven=(i+1)%fork.length;
			
		}else {
			firstodd=(i+1)%fork.length;
			secondeven=i;
		}
		
	}
	
	private void think() {
		try {
			System.out.println("spavam"+id);

			Thread.sleep((int)Math.random()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void eat() {
		try {
			System.out.println("jedem"+id);

			Thread.sleep((int)Math.random()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			think();
			fork[firstodd].acquireUninterruptibly();
			fork[secondeven].acquireUninterruptibly();
			eat();
			fork[secondeven].release();
			fork[firstodd].release();
			
		}
	}
	

}
