package cn.ccsu.sort;

public class SelectSort<T extends Comparable<T>> {

	public void sort(T[] a) {

		T tmp = null;
		int i = 0;
		int j = 0;
		int index = 0;
		
		for (i = 0; i < a.length - 1; i++) {
			
			index = i;
			for (j = i+1; j < a.length; j++) {
				if (a[j].compareTo(a[index]) < 0)
					index = j;
			}

			if(index != -1)
			{
				tmp = a[index];
				a[index] = a[i];
				a[i] = tmp;
				
			}
			
		}
	}
}
