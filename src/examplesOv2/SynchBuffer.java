package examplesOv2;


public class SynchBuffer 
{
	
	int buffer=Integer.MIN_VALUE;

// Three versions of the methods. Try to understand what is wrong with each version	
	
	public synchronized void setNumber(int x) throws InterruptedException
	{	
		if(buffer==Integer.MIN_VALUE)
		buffer=x;
	}
	
	public synchronized int getNumber() throws InterruptedException
	{
		int x=0;
		if(buffer!=Integer.MIN_VALUE)
		x=buffer;
		buffer=Integer.MIN_VALUE;
		
		return x;
	}
//	
//}


//	public  void setNumber(int x) throws InterruptedException {
//		
//		while (buffer != Integer.MIN_VALUE) {
////			System.out.println("set going to sleep");
//			Thread.sleep(1);
//		}
//		synchronized(this){
//		buffer = x;
//		}
//	}
//
//	public  int getNumber() throws InterruptedException {
//		int x = 0;
//		while (buffer == Integer.MIN_VALUE) {
////			System.out.println("get going to sleep");
//			Thread.sleep(1);
//		}
//		synchronized(this){
//		x = buffer;
//		buffer = Integer.MIN_VALUE;
//		}
//
//		return x;
//	}
//}



//public synchronized void setNumber(int x) throws InterruptedException
//{	
//	while(buffer!=Integer.MIN_VALUE)
//	{
//		wait();
//	}
//	buffer=x;
//	notifyAll();
//}
//
//public synchronized int getNumber() throws InterruptedException
//{
//	int x=0;
//	while(buffer==Integer.MIN_VALUE)
//	{
//		wait();
//	}
//	x=buffer;
//	buffer=Integer.MIN_VALUE;
//	notifyAll();
//	return x;
//}

}
