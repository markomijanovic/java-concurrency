package ra.ac.bg.etf.kdp.cas;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class boundedbuffgotova<T> {
	final ConcurrentLinkedDeque<T> deque=new ConcurrentLinkedDeque<>();
	
	public void put(T x) {
		deque.offerLast(x);
	}
	
	public T get() {
		T item;
		
		while((item = deque.pollFirst())==null) {
			Thread.yield();
		}
		return item;
	}
	
	

}
