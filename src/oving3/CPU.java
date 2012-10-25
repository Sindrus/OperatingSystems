package oving3;

public class CPU {
	
	private Queue cpuQueue;
	private Gui gui;
	private long maxCpuTime;
	private Process currentProcess;
	private boolean runningProcess;
	
	public CPU(Queue cpuQueue, Gui gui, long maxCpuTime){
		this.cpuQueue = cpuQueue;
		this.gui = gui;
		this.maxCpuTime = maxCpuTime;
	}
	
	public void addProcess(Process p){
		cpuQueue.insert(p);
	}
	
	public Process getCurrent(){
		Process p = currentProcess;
		currentProcess = null;
		return p;
	}
	
	public boolean isIdle(){
		return currentProcess == null;
	}
	
	public Process work(){
		if(!cpuQueue.isEmpty()){
			Process p = (Process) cpuQueue.removeNext();
			currentProcess = p;
			gui.setCpuActive(p);
			return p;
		}else{
			currentProcess = null;
			gui.setCpuActive(null);
			return currentProcess;
		}
	}
	
	public void doProcess(Process p){
		cpuQueue.insert(p);
	}

	public long getMaxCpuTime() {
		return maxCpuTime;
	}
	
}

/*
anti-snap
øretelefoner
liten treningsbag
pulsklokke
treningstøy
ny rettetang
ørevarmere
*/