public class Main {
	public static void main(String[] args) {
		CountDown countDown = new CountDown();
		CountDownThread t1 = new CountDownThread(countDown);
		t1.setName("Thread 1");
		CountDownThread t2 = new CountDownThread(countDown);
		t2.setName("Thread 2");

		t1.start();
		t2.start();
	}

}

class CountDown {

		private int i; //if i is private instance variable, then both together make i zero, not two separate i values
	public void doCountDown() { // Method synchronization using synchronized key word here
		String color;
		switch(Thread.currentThread().getName()) {
			case "Thread 1": 
					color = ThreadColor.ANSI_CYAN;
					break;
			case "Thread 2":
					color = ThreadColor.ANSI_PURPLE;
					break;
			default:
					color = ThreadColor.ANSI_RED;
					break;
		}

		//synchronized(color) { // no local variables, so using color doesn't help synchronization
		synchronized(this) {
			for(i = 10; i > 0; i--) { // If i is local variable, thread 1 and 2 create separate count downs
				System.out.println(color + Thread.currentThread().getName()+":"+i);
			}
		}
 	}
}

class CountDownThread extends Thread {
	private CountDown threadCountDown;

	public CountDownThread(CountDown countDown) {
		threadCountDown = countDown;
	} 

	public void run() {
		threadCountDown.doCountDown();
	}
}