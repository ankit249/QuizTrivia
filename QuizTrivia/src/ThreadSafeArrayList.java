import java.util.ArrayList;
import java.util.List;

// Write a ThreadSafe ArrayList
// Its possible that the client is more read centric with occasional writes
public class ThreadSafeArrayList<T> {

	private final List<T> list = new ArrayList<T>();

	public void set(T o) {
		list.add(o);
		System.out.println("Adding element by thread" + Thread.currentThread().getName());
	}

	public T get(int i) {
		System.out.println("Printing elements by thread" + Thread.currentThread().getName());
		return list.get(i);
	}

	public static void main(String[] args) {
		ThreadSafeArrayList<String> threadSafeArrayList = new ThreadSafeArrayList<>();
		threadSafeArrayList.set("1");
		threadSafeArrayList.set("2");
		threadSafeArrayList.set("3");

		System.out.println("Printing the First Element : " + threadSafeArrayList.get(1));
	}
}
