package oving3;

public class CPU {
	
	/** The queue of processes waiting for cpuTime */
	private Queue cpuQueue;
	/** A reference to the statistics collector */
	private Statistics stats;
	/**long to keep track of what is the maximum cpu-time */
	private long maxCPUTime;
//	reference to the gui
	private Gui gui;
//	reference to the currently active process
	private Process currentProcess;
	
	/**
	 * Constructor
	 */
	public CPU(Queue cpuQue, Statistics stats, long maxCPUTime, Gui gui){
		this.cpuQueue = cpuQue;
		this.stats = stats;
		this.maxCPUTime = maxCPUTime;
		this.gui = gui;
	}

	public long getMaxCPUTime() {
		return maxCPUTime;
	}
	
	/**
	 * Add a new process to the cpuqueue
	 */
	public void addProcess(Process p){
		cpuQueue.insert(p);
		stats.maxCPUQueueSize = Math.max(cpuQueue.getQueueLength(), stats.maxCPUQueueSize);
	}
	
	/**
	 * Returns the current process
	 */
	public Process getCurrent(){
		Process p = currentProcess;
		currentProcess = null;
		gui.setCpuActive(null);
		return p;
	}
	
	/**
	 * Start the next process if one exist
	 */
	public Process start(){
		if(cpuQueue.isEmpty()){
			currentProcess = null;
		}else{
			currentProcess = (Process) cpuQueue.removeNext();
			gui.setCpuActive(currentProcess);
		}
		return currentProcess;
	}
	
	/**
	 * Check to see if the cpu is idle
	 */
	public boolean isIdle(){
		return currentProcess == null;
	}
	
	public void timePassed(long time){
		stats.totalTimeInCUPQueue += cpuQueue.getQueueLength() * time;
	}
}