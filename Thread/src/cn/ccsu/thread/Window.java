package cn.ccsu.thread;

public class Window implements Runnable {

	private int ticket;

	public void run() {
		// TODO Auto-generated method stub

		
			
			while (true) {

				synchronized(this){
					this.notifyAll();
					if (this.ticket > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ ":" + (this.ticket--));
					} else {
						break;
					}
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					System.out.println("\n"+Thread.currentThread().getName()+":$$\n");
				}
			}
			
		
		

	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

}
