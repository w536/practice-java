package leetcode.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * No.349 - intersection of two arrays. 
 * Given two arrays, write a function to calculate their intersection.
 * @see https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author w536
 *
 */
public class IntersectionOfTwoArrays {
	static String ARRAY_SEPARATOR = ", ";

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5 };
		int[] nums2 = { 1, 1, 76, 1, 1, 3, 5, 12 };
		int[] result = intersection(nums1, nums2);
		// display the result array in a prettier way
		// omit the last comma
		for (int i = 0; i < result.length; i++) {
			if (i == result.length - 1) {
				System.out.print(result[i]);
			} else {
				System.out.print(result[i] + ARRAY_SEPARATOR);
			}
		}
		System.out.println();
	}

	private static Set<Integer> convertIntArrayToSet(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int ele : arr) {
			if (!set.contains(ele))
				set.add(ele);
		}
		return set;
	}

	private static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = convertIntArrayToSet(nums1);
		Set<Integer> set2 = convertIntArrayToSet(nums2);
		return getIntersection(set1, set2);
	}

	
	private static int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
		if (set1.size() > set2.size()) {
			getIntersection(set2, set1);
		}
		Set<Integer> resultSet = new HashSet<>();
		for (int num : set1) {
			if (set2.contains(num)) {
				resultSet.add(num);
			}
		}
		return resultSet.stream().mapToInt(Integer::valueOf).toArray();
	}
}
