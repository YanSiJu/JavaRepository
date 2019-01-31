package cn.csu.test;

class Aclass {
	public Aclass() {
		System.out.println("A");
	}

	protected static class M {
	}
}

class Bclass extends Aclass {
	public Bclass() {
		System.out.println("B");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Bclass b = new Bclass();
	}
}
