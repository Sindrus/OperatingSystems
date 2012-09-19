package oving2;

/**
 * This class implements the doorman's part of the
 * Barbershop thread synchronization example.
 */
public class Doorman implements Runnable{
	
	private CustomerQueue q;
	private Gui gui;
	private Thread t;
	
	/**
	 * Creates a new doorman.
	 * @param queue		The customer queue.
	 * @param gui		A reference to the GUI interface.
	 */
	public Doorman(CustomerQueue queue, Gui gui) { 
		super();
		q = queue;
		this.gui = gui;
		
		t = new Thread(this);
		
/*		try {
			q.addCustomer(new Customer());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * Starts the doorman running as a separate thread.
	 */
	public void startThread() {
		t.start();
	}

	/**
	 * Stops the doorman thread.
	 */
	public void stopThread() {
//		t.stop();
	}

	@Override
	public void run() {
		while(true){
			try {
				q.addCustomer(new Customer());
				t.sleep(Globals.doormanSleep+(int)(Math.random()*(150-50+1)));
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	// Add more methods as needed
}
