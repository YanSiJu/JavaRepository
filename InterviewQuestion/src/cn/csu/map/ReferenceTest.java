package cn.csu.map;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class ReferenceTest {

	public static void main(String[] args) {
		String str = "archLinux";
		Reference<String> ref = new WeakReference<String>(str);
		System.out.println("ref.get():" + ref.get());
		str = null;
		System.gc();
		System.out.println("ref.get():" + ref.get() + "\nstr:" + str);
	}

}
