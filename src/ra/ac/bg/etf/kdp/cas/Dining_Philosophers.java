package ra.ac.bg.etf.kdp.cas;

import java.util.concurrent.Semaphore;

public class Dining_Philosophers {
	public static final int N=5;
	
	public static void main(String[] args) {
		int n=N;
		Semaphore[] fork= new Semaphore[n];
		Philosopher[] philosopher= new Philosopher[n];
		int i;
		for(i=0;i<N;i++) fork[i]=new Semaphore(1);
		for(i=0;i<N;i++) philosopher[i]=new Philosopher(i, n, fork);
		philosopher[0].start();
		philosopher[1].start();
		philosopher[2].start();
		philosopher[3].start();
		philosopher[4].start();

	}
}
