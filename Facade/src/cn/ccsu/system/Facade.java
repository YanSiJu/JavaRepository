package cn.ccsu.system;

public class Facade {

	private CPU cpu;
	private OS os;
	private Storage str;
	private Disk disk;

	public Facade() {
		cpu = new CPU();
		disk = new Disk();
		os = new OS();
		str = new Storage();
	}

	public void on() {
		if (str.check()) {
			if (cpu.run()) {
				if (disk.read()) {
					if (os.load()) {
						System.out.println("\n检测内存....\r\n" + "cpu在运行...\r\n" + "读取硬盘\r\n" + "操作系统载入...");
						System.out.println("\n电脑正常运行...");
						return;
					}
				}
			}
		}

		System.out.println("内存失败\r\n" + "cpu错误\r\n" + "硬盘错误\r\n" + "操作系统关闭....");
	}

}
