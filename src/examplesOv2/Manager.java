package examplesOv2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Manager 
{
	
	public void runme()
	{
		
		SimpleBuffer q=new SimpleBuffer();
		ExecutorService es=Executors.newCachedThreadPool();
		
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		
		
		//ArrayList<Thread> threads=new ArrayList<Thread>();
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		es.execute(t2);
		es.execute(t1);
		
		es.shutdown();
		
	}
	
	
	public void runme2()
	{
		SynchBuffer q=new SynchBuffer();
		ExecutorService es=Executors.newCachedThreadPool();
		
		Producer2 p=new Producer2(q);
		Consumer2 c=new Consumer2(q);
		
		
		//ArrayList<Thread> threads=new ArrayList<Thread>();
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		es.execute(t2);
		es.execute(t1);
		
		es.shutdown();
		
	}
	
	public static void main(String args[])
	{
		Manager manager=new Manager();
		manager.runme2();
	}

}
