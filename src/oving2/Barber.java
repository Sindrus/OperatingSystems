package oving2;

/**
 * This class implements the barber's part of the
 * Barbershop thread synchronization example.
 */
public class Barber implements Runnable{
	private CustomerQueue q;
	private Gui gui;
	private int pos;
	private Thread t;
	private int count;
	
	/**
	 * Creates a new barber.
	 * @param queue		The customer queue.
	 * @param gui		The GUI.
	 * @param pos		The position of this barber's chair
	 */
	public Barber(CustomerQueue queue, Gui gui, int pos) { 
		super();
		q=queue;
		this.gui=gui;
		this.pos=pos;
		t = new Thread(this);
		count=0;
	}

	/**
	 * Starts the barber running as a separate thread.
	 */
	public void startThread() {
		t.start();
	}

	/**
	 * Stops the barber thread.
	 */
	public void stopThread() {
		t.stop();
	}

	@Override
	public void run() {
		while(true){
			try {
				count++;
				Customer c=q.getCustomer();
				gui.println("Barber "+pos+" getting customer nr "+c.getCustomerID());
				gui.fillBarberChair(pos, c);
				t.sleep(Globals.barberWork);
				gui.emptyBarberChair(pos);
				q.cashier();
				t.sleep(Globals.barberSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Add more methods as needed
}