package examplesOv2;

import java.util.Random;


public class Producer2 implements Runnable
{
	private Random rand=new Random();
	private SynchBuffer buffer;
	
	public Producer2(SynchBuffer b)
	{
		this.buffer=b;
	}
	
	public void produce() throws InterruptedException
	{
		int sum=0;
		for(int i=0;i<Constants.ROUNDS;i++)
		{
//			Thread.sleep(rand.nextInt(3));
			int x=rand.nextInt(10);
			sum+=x;
			buffer.setNumber(x);
		}
		
//Consumer prints a similar line. The two sums (producer's and consumer's should be equal).
		System.out.println("P:"+sum); 
	}

	@Override
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
