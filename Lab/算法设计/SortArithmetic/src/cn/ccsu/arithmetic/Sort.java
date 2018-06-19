package cn.ccsu.arithmetic;


/**
 * @author Bill
 *
 * @param <T>
 */
public class Sort<T extends Comparable<T>> {

	private static final int CUTOOF = 2;

	private T median(T[] a, int left, int right) {

		int center = (left + right) / 2;
		if (a[center].compareTo(a[left]) < 0) {
			swap(a, left, center);
		}
		if (a[right].compareTo(a[left]) < 0) {
			swap(a, left, right);
		}
		if (a[right].compareTo(a[center]) < 0) {
			swap(a, center, right);
		}

		// Place pivot at position right - 1
		swap(a, center, right);
		return a[right];

	}

	public void quicklySort(T[] a) {
		quicklySort(a, 0, a.length - 1);
	}

	private void quicklySort(T[] a, int left, int right) {

		if (left + CUTOOF <= right) {
			T pivot = median(a, left, right);
			int i = left;
			// change
			int j = right;
			for (;;) {
				while (a[++i].compareTo(pivot) < 0) {

				}
				while (a[--j].compareTo(pivot) > 0) {

				}
				if (i < j) {
					swap(a, i, j);
				} else {
					break;
				}
			}

			// change
			swap(a, i, right);
			quicklySort(a, left, i - 1);

			quicklySort(a, i + 1, right);
		} else {
			insetrSort(a);
		}

	}

	private void swap(T[] a, int m, int n) {

		T tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}

	public void insetrSort(T[] a) {
		// TODO Auto-generated method stub

		T tmp;
		int j;
		for (int i = 1; i < a.length; i++) {
			tmp = a[i];
			for (j = i - 1; j >= 0; j--) {
				if (a[j].compareTo(tmp) > 0)
					a[j + 1] = a[j];
				else {
					break;
				}

			}
			a[j + 1] = tmp;
		}
	}

	public void mergeSort(T[] a) {
		/*
		 * List<T> tmpArray = new ArrayList<>(); for (int i = 0; i < a.length; i++) {
		 * tmpArray.add(0, null); }
		 */
		@SuppressWarnings("unchecked")
		T[] tmpArray = (T[]) new Comparable[a.length];
		// System.out.println("tmpArray.get(0):"+tmpArray.get(0));
		mergeSort(a, tmpArray, 0, a.length - 1);
	}

	private void mergeSort(T[] a, T[] tmpArray, int left, int right) {
		if (left < right) {

			int center = (left + right) / 2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center + 1, right);
		}

	}

	private void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd) {

		int leftEnd = rightPos - 1;
		int elementNums = rightEnd - leftPos + 1;
		int index = leftPos;

		for (; leftPos <= leftEnd && rightPos <= rightEnd;) {

			if (a[rightPos].compareTo(a[leftPos]) < 0) {
				tmpArray[index++] = a[rightPos++];
			} else {
				tmpArray[index++] = a[leftPos++];
			}

		}

		while (rightPos <= rightEnd) {
			tmpArray[index++] = a[rightPos++];

		}

		while (leftPos <= leftEnd) {
			tmpArray[index++] = a[leftPos++];
		}

		for (int k = 0; k < elementNums; k++, rightEnd--) {
			a[rightEnd] = tmpArray[rightEnd];

		}

	}
}
