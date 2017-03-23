package Leetcode;

import java.util.*;

public class SingleNumber {
	public static void main(String[] args) {
		int[] strs = { 2, 2, 1 };
		singleNumber(strs);
	}

	public static int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.remove(nums[i]);
			}
		}
		Set<Integer> a = map.keySet();
		Iterator<Integer> it = a.iterator();
		int res = -1;
		while (it.hasNext()) {
			res = it.next();
		}
		return res;
	}
	public int singleNumber2(int[] nums) {
	    int ans =0;
	    
	    int len = nums.length;
	    for(int i=0;i!=len;i++)
	        ans ^= nums[i];
	    
	    return ans;
	    
	}
}
