package examplesOv2;

import java.util.Random;


public class Consumer2 implements Runnable{
	
	
	private Random rand=new Random();
	private SynchBuffer buffer;
	
	public Consumer2(SynchBuffer b)
	{
		this.buffer=b;
	}
	
	public void consume() throws InterruptedException
	{
		int sum=0;
		for(int i=0;i<Constants.ROUNDS;i++)
		{
//			Thread.sleep(rand.nextInt(3));
			sum+=buffer.getNumber();
		}
		
		System.out.println("C:"+sum);
	}

	@Override
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


