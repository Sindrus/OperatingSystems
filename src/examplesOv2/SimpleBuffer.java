package examplesOv2;


public class SimpleBuffer {
	int buffer = 0;

	/*	public synchronized void add(int value){
		
			buffer += value;
		
		
	}

	public synchronized void subtract(int value) throws InterruptedException {
		buffer -= value;
	}

	public int readValue() {
		return buffer;
	}*/

//uncomment the following code and comment the above one in order and run again
	public synchronized  void add(int value){
		
			buffer += value;
		
		
	}

	public synchronized  void subtract(int value) throws InterruptedException {
		buffer -= value;
	}
	public int readValue() {
		return buffer;
	}


}
