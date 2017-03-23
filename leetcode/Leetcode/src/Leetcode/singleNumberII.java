package Leetcode;

import java.util.*;
import java.util.Map.Entry;

public class singleNumberII {

	public static void main(String[] args) {
		int[] strs = { 2, 2, 1 };
		//singleNumberII(strs);
		int a=2;
		System.out.println("a 非的结果是："+(~a));
	}

	public static int singleNumberII(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
				set.add(nums[i]);
			} else {
				set.remove(nums[i]);
				//map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		return -1;
	}
}