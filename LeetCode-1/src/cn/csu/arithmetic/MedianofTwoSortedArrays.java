package cn.csu.arithmetic;

/**
 * @author Bill
 *
 */
public class MedianofTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		int length = m + n;
		int i = 0;
		int j = 0;
		int k = 0;
		int min = 0;
		int flag = 0;
		int a = 2;
		if ((m + n) % a != 0) {
			int mid = 0;
			while (i < m && j < n) {

				flag++;
				if (nums1[i] < nums2[j]) {
					mid = nums1[i++];
				} else {
					mid = nums2[j++];
				}

				//
				if (flag == length / 2 + 1) {
					return mid;
				}

			}

			if (i < m) {
				for (; i < m; i++) {
					flag++;
					if (flag == length / 2 + 1) {
						return nums1[i];
					}

				}
			} else {
				for (; j < n; j++) {
					flag++;
					if (flag == length / 2 + 1) {
						return nums2[j];
					}

				}
			}
		} else {
			int[] c = new int[2];
			while (i < m && j < n) {

				if (nums1[i] < nums2[j]) {
					min = nums1[i++];
				} else {
					min = nums2[j++];
				}
				flag++;
				if (flag == length / 2 || flag == length / 2 + 1) {
					c[k++] = min;
				}

			}

			if (k < c.length) {
				if (i < m) {
					for (; i < m; i++) {
						flag++;
						if (flag == length / 2 || flag == length / 2 + 1) {
							c[k++] = nums1[i];
						}

					}
				} else {
					for (; j < n; j++) {
						flag++;
						if (flag == length / 2 || flag == length / 2 + 1) {
							c[k++] = nums2[j];
						}

					}
				}
			}
			// System.out.println("c:" + Arrays.toString(c));
			return (c[0] + c[1]) / 2.0;
		}
		return 0;
	}
}
