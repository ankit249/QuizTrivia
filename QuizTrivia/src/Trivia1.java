/** WHAT DOES THE count PRINT AT THE END **/
class A {
	int count = 0;

	public synchronized void increament() throws InterruptedException {
		Thread.sleep(100);
		for (int i = 0; i < 10; i++) {
			count++;
		}
	}
}

public class Trivia1 {
	public static void main(String[] args) {
		final A a = new A();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					a.increament();
				} catch (InterruptedException ie) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					a.increament();
				} catch (InterruptedException ie) {
				}
			}
		});

		t1.start();
		t2.start();

		System.out.println(a.count);
	}
}
