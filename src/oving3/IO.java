package oving3;

public class IO {
	private Queue IOQueue;
	private Gui gui;
	private long IOWait;
	private Process currentProcess;
	private Statistics statistics;
	
	public IO(Queue q,Statistics statistics, long IOWait, Gui g){
		this.statistics = statistics;
		this.IOQueue = q;
		this.gui = g;
		this.IOWait = IOWait;
	}
	
	public boolean addProcess(Process p){
		IOQueue.insert(p);
		if(currentProcess == null){
			start();
			return true;
		}else
			return false;
	}
	
	public Process start(){
		if (IOQueue.isEmpty()){
			currentProcess = null;
			gui.setCpuActive(null);
			return null;
		}
		currentProcess = (Process)IOQueue.removeNext();
		currentProcess = currentProcess;
		gui.setIoActive(currentProcess);
		return currentProcess;
	}
	
	public long getIOTime(){
		return (long)(Math.random() * (IOWait*2) + IOWait/2 );
	}
	
	public Process getCurrent(){
		Process p = currentProcess;
		currentProcess=null;
		return p;
	}
	
/*	public void updateTime(long timePassed){
		statistics.io
	}*/
}
