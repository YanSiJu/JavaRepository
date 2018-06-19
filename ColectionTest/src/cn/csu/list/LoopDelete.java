package cn.csu.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class LoopDelete {
	
	@Test
	public void deleteWithItr() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		Integer n = 4;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer x = it.next();
			if (n.equals(x)) {
				it.remove();
//				list.remove(x);
			}
		}

	}

	@Test
	public void deleteWithForeach() {
		
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		Integer n = 4;
		for (Integer e : list) {
			if (n.equals(e)) {
				list.remove(e);
			}
		}

	}
}
