package leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * No.941 - valid mountain array. 
 * Given an integer array A, it returns true if it is a valid mountain array, 
 * otherwise it returns false. 
 * Description:
 * If A satisfies the following conditions, then it is an array of mountains: 
 * (1) A.length >= 3; 
 * (2) Under the condition of 0 <i <A.length-1, there is i such that: 
 * (2.1) A[0] < A[1] < ... A[i-1] < A[i]; 
 * (2.2) A[i] > A[i+1] > ... > A[A.length - 1].
 * @see https://leetcode-cn.com/problems/valid-mountain-array/
 * @author w536
 */
public class ValidMountainArray {
	public static void main(String[] args) {
		List<int[]> set = new ArrayList<>();
		set.add(new int[] { 0, 1, 2, 3, 1, 0 });
		set.add(new int[] { 3, 5, 12, 33, 2 });
		set.add(new int[] { 0, 1 });
		set.add(new int[] { 3, 2, 1, 0 });
		set.add(new int[] { 0, 1, 2, 2, 1 });
		set.add(new int[] { 0, 1, 0, 1, 0 });
		for (int[] arr : set) {
			System.out.print(validMountainArray(arr)+"\t-> { ");
			for (int ele : arr)
				System.out.print(ele + " ");
			System.out.println("}");
		}
	}

	private static boolean validMountainArray(int[] arr) {
		int n = arr.length, i = 0;
		if (n > 2) {
			while (i + 1 < n && arr[i] < arr[i + 1]) {
				i++;
			}
			if (i == 0 || i == n - 1) {
				return false;
			}
			while (i + 1 < n && arr[i] > arr[i + 1]) {
				i++;
			}
			return i == n - 1;
		}
		return false;
	}
}
