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
						System.out.println("\n����ڴ�....\r\n" + "cpu������...\r\n" + "��ȡӲ��\r\n" + "����ϵͳ����...");
						System.out.println("\n������������...");
						return;
					}
				}
			}
		}

		System.out.println("�ڴ�ʧ��\r\n" + "cpu����\r\n" + "Ӳ�̴���\r\n" + "����ϵͳ�ر�....");
	}

}
