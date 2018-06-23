
public class CreateThreads{

	public static void main(String[] args) {
		System.out.println("In main thread");

		Thread anotherThread = new AnotherThread();
		anotherThread.start(); //asks JVM to run the run() method for thread

		new Thread() {
			public void run() {
				System.out.println("Hello from the anoynmous");
			}
		}.start();
		System.out.println("In main thread again");
		//anotherThread.start(); //leads to exception => IllegalThreadStateException
		Thread runnableThread = new Thread(new RunnableThread());
		runnableThread.start();
		runnableThread.setName("Cute little thread");
		Thread runnableTest = new Thread(new RunnableThread() {
			@Override
			public void run() {
				System.out.println("In anonymous Runnable subclass");
				//super.run();
				try {
					Thread.sleep(10000);
				}
				catch(InterruptedException e) {
					System.out.println("Another thread interrupted me");
				}

				System.out.println("I am done sleeping");
			}}
			);

		runnableTest.start();
	}
}