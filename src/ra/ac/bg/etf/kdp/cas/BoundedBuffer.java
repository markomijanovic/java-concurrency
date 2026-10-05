package ra.ac.bg.etf.kdp.cas;

public class BoundedBuffer<T> {
	public static final int N=100;
	
	final T[] items =(T[]) new Object[N];
	int putptr,takeptr,count;
	
	public synchronized void put(T x) throws InterruptedException{
		while(count==items.length) {
			wait();
		}
		items[putptr]=x;
		putptr=(putptr+1)%items.length;
		count++;
		notifyAll();
	}
	public synchronized T get() throws InterruptedException{
		while(count==0) {
			wait();
		}
		T x=items[takeptr];
		takeptr=(takeptr+1)%items.length;
		count--;
		notifyAll();
		return x;
	}
}
