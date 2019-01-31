package test.run;

public class MainDemon {

	public static void main(String[] args) {
		Thread.currentThread().setDaemon(true);
		// try {
		// Thread.currentThread().setDaemon(true);
		// } finally {
		// System.out.println("daemon finally block");
		// }

	}

}
