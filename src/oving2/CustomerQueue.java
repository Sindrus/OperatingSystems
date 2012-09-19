package oving2;

//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.Lock;

/**
 * This class implements a queue of customers as a circular buffer.
 */
public class CustomerQueue {
	
	private final Customer[] buffer;
	private final int capacity;
	private final Gui gui;
//	private final Lock lock = new ReentrantLock();
//	private final Condition notFull = lock.newCondition();
//	private final Condition notEmpty = lock.newCondition();
	
	private int first;
	private int last;
	private int count;
	private boolean bufferFull;
	private boolean bufferEmpty;
	
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
    	bufferFull=false;
    	bufferEmpty=true;
	}
    
	// Add more methods as needed
    
    public synchronized void addCustomer(Customer customer) throws InterruptedException{
    	if(count>capacity)
    		bufferFull=true;
    	while(bufferFull){
    		gui.println("buffer is full");
    		wait();
    	}
    	buffer[last]=customer;
    	bufferEmpty=false;
    	gui.println("Customer "+customer.getCustomerID()+" added");
    	last = (last+1)%capacity;
		gui.fillLoungeChair(count, customer);
    	count++;
    	notifyAll();
    }
    
    public synchronized Customer getCustomer() throws InterruptedException{
//    	gui.println("try to get customer");
    	if(count<=0)
    		bufferEmpty=true;
    	while(bufferEmpty)
    		wait();
    	Customer customer = buffer[first];
    	bufferFull=false;
    	gui.println("Removing customer "+customer.getCustomerID()+" from line");
    	first = (first+1)%capacity;
    	gui.emptyLoungeChair(count);
    	count--;
    	notifyAll();
    	return customer;
    }
    
    
    
    /*public void addCustomer(Customer customer) throws InterruptedException{
    	gui.println("legger til kunde");
    	lock.lock();
    	
    	try{
    		while(count == capacity){
    			notFull.await();
    		}
    		buffer[last]=customer;
    		last = (last+1)%capacity;
    		
    		gui.fillLoungeChair(count, customer);
    		

    		count++;
    		
    		notFull.signal();
    	}finally{
    		lock.unlock();
    	}
    	gui.println("kunde nr: "+buffer[0].getCustomerID());
    }
    
    public Customer getCustomer() throws InterruptedException{
    	lock.lock();
    	try{
    		while(count==0){
    			notEmpty.await();
    		}
    		
    		Customer customer = buffer[first];
    		first = (first+1)%capacity;
    		
    		gui.emptyLoungeChair(count);

    		count--;
    		
    		notEmpty.signal();
    		return customer;
    	}finally{
    		lock.unlock();
    	}
    }*/

}
