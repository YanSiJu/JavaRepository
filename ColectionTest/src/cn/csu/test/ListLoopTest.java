package cn.csu.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

/**
 * 测试Random Access List(随机访问列表)如 ArrayList 和 Sequence Access List(顺序访问列表)如
 * LinkedList </br>
 * 不同遍历算法的效率</br>
 * 结论：前者用循环，后者用迭代器
 */

public class ListLoopTest {

	/**
	 * 初始化 list，添加n个元素
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<Integer> initList(List<Integer> list, int n) {
		for (int i = 0; i < n; i++)
			list.add(i);
		return list;
	}

	/**
	 * 遍历 list，判断是否实现 RandomAccess 接口来使用不同的遍历方法
	 * 
	 * @param list
	 */
	public static void accessList(List<Integer> list) {
		long startTime = System.currentTimeMillis();

		if (list instanceof RandomAccess) {
			System.out.println("实现了 RandomAccess 接口...");
			for (int i = 0; i < list.size(); i++) {
				list.get(i);
			}
		} else {
			System.out.println("没实现 RandomAccess 接口...");
			for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
				iterator.next();
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("遍历时间：" + (endTime - startTime));
	}

	/**
	 * loop 遍历 list
	 */
	public static void accessListByLoop(List<Integer> list) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		long endTime = System.currentTimeMillis();
		System.out.println("loop遍历时间：" + (endTime - startTime));
	}

	/**
	 * 迭代器遍历
	 */
	public static void accessListByIterator(List<Integer> list) {
		long startTime = System.currentTimeMillis();

		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			iterator.next();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Iterator遍历时间：" + (endTime - startTime));
	}

	public static void main(String[] args) {
		List<Integer> aList = (ArrayList<Integer>) initList(new ArrayList<>(), 2000000);
		List<Integer> lList = (LinkedList<Integer>) initList(new LinkedList<>(), 2000000);

		accessList(aList);
		accessList(lList);

		System.out.println("ArrayList");
		accessListByLoop(aList);
		accessListByIterator(aList);

		System.out.println("LinkedList");
		accessListByLoop(lList);
		accessListByIterator(lList);
	}

}

// 作者：LD00000 链接：https:// www.jianshu.com/p/89aaaee1077e
// 來源：简书 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。