package ra.ac.bg.etf.kdp.cas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class boundeduff<T> {
	 final Lock lock=new ReentrantLock();
	 final Condition notFull=lock.newCondition();
	 final Condition notEmpty=lock.newCondition();
	 
	 public static final int N=100;
	 final T[] items =(T[]) new Object[N];
	 int putptr,takeprt,count;
	 
	 public void put(T x) throws InterruptedException{
		 lock.lock();
		 try {
			 while(count==items.length) {
				 notFull.await();
			 }
			 items[putptr]=x;
			 putptr=(putptr+1)%items.length;
			 count++;
			 notEmpty.signal();
		 }finally {
			lock.unlock();
		}
	 }
	 
	 public T get() throws InterruptedException{
		 lock.lock();
		 try {
			 while(count==0) {
				 notEmpty.wait();
			 }
			 T x=items[takeprt];
			 takeprt=(takeprt+1)% items.length;
			 count--;
			 notFull.signal();
			 return x;
		 }finally {
			lock.unlock();
		}
	 }
}
