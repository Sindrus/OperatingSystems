package examplesOv2;

public class Producer implements Runnable {
	SimpleBuffer q;
	
	public Producer(SimpleBuffer q) {
		this.q = q;
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

	public void produce() throws InterruptedException {
		for (int i = 0; i < Constants.ROUNDS; i++) {
			System.out.print("");
			q.add(1);
		}
		System.out.println("P" + q.readValue());
	}

}
