package oving3;

public class IO {
	
	/** The queue of processes waiting IO time */
	private Queue ioQueue;
	/** A reference to the statistics collector */
	private Statistics stats;
	/** The average process time */
	private long avgIOTime;
	/** A reference to the gui, so we can animate stuff */
	private Gui gui;
	/** A reference to the currently active process,
	 * it will need to occasionally be set to "null" so the
	 * rest of the program knows the IO device is free.
	 */
	private Process currentProcess;
	
	/**
	 * Constructor
	 */
	public IO(Queue ioQueue, Statistics stats, long avgIOTime, Gui gui){
		this.ioQueue = ioQueue;
		this.stats = stats;
		this.avgIOTime = avgIOTime;
		this.gui = gui;
	}
	
	public long getIoTime() {
		return (long) (Math.random() * (avgIOTime * 2) + (long)(Math.floor(avgIOTime/ 2)));
	}
	
	/**
	 * Returning the current process being processed by the cpu
	 */
	public Process getCurrent(){
		Process p = currentProcess;
		currentProcess = null;
		gui.setIoActive(null);
		return p;
	}
	
	public void timePassed(long time){
		stats.totalTimeInIOQueue += ioQueue.getQueueLength() * time;
	}
	
	/**
	 * Adding a new process to the processqueue, 
	 * and start the process if there are no current process
	 */
	public boolean addProcess(Process p){
		ioQueue.insert(p);
		stats.maxIOQueueSize = Math.max(stats.maxIOQueueSize, ioQueue.getQueueLength());
		if(currentProcess == null){
			start();
			return true;
		}
		return false;
		
	}
	
	/**
	 * Start the current process and return it
	 */
	public Process start() {
		if (ioQueue.isEmpty()) {
			currentProcess = null;
			gui.setIoActive(null);
		}else{
			currentProcess = (Process) ioQueue.removeNext();
			gui.setIoActive(currentProcess);
		}
		return currentProcess;
	}	
}