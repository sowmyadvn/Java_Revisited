
public class AnotherThread extends Thread {

	@Override
	public void run() {
		
		System.out.println("In another thread"+currentThread().getName());
	}
	
}