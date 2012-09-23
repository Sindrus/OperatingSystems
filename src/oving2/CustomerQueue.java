package oving2;

//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.Lock;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	
	private Customer[] buffer;
	private int capacity;
	private Gui gui;
	
	private int first;
	private int last;
	private int count;
	private int customersCome;
	private int customersPaied;
	
	/**
	 * Creates a new customer queue.
	 * @param queueLength	The maximum length of the queue.
	 * @param gui			A reference to the GUI interface.
	 */
    public CustomerQueue(int queueLength, Gui gui) {
    	super();
    	
    	gui.println("starting queue");
    	
    	this.capacity = queueLength;
    	this.gui = gui;
    	this.buffer = new Customer[capacity];
    	count=0;
    	last=0;
    	first=0;
	customersCome=0;
	customersPaied=0;
    }
    
	// Add more methods as needed
    
    public synchronized void addCustomer(Customer customer) throws InterruptedException{
    	while(count>=capacity){
    		gui.println("buffer is full");
    		wait();
    	}
    	buffer[last]=customer;
    	gui.println("Customer "+customer.getCustomerID()+" added");
	gui.fillLoungeChair(last, customer);
    	last = (last+1)%capacity;
    	count++;
	customersCome++;
	System.out.println("Kunder som har kommet "+customersCome);
    	notifyAll();
    }
    
    public synchronized Customer getCustomer() throws InterruptedException{
    	while(count<=0){
		gui.println("buffer is empty");
    		wait();
    	}
    	Customer customer = buffer[first];
    	gui.emptyLoungeChair(first);
    	gui.println("Removing customer "+customer.getCustomerID()+" from line");
    	first = (first+1)%capacity;
    	count--;
    	notifyAll();
    	return customer;
    }
    
    public synchronized void cashier() throws InterruptedException{
	customersPaied++;
	System.out.println("Customers paid: "+customersPaied);
    }
}
