package examplesOv2;

public class Consumer implements Runnable {
	SimpleBuffer q;

	public Consumer(SimpleBuffer q) {
		this.q = q;
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
	
	public void consume() throws InterruptedException {

		for (int i = 0; i < Constants.ROUNDS; i++) {
			System.out.print("");
			q.subtract(1);

		}
		System.out.println("C" + q.readValue());
	}
}
