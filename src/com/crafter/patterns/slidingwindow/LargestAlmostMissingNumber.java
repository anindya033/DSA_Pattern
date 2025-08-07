package com.crafter.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LargestAlmostMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {3,9,2,1,7}; int k = 3;
		largestAlmostMissingNumber(nums, k);
	}
	
	public static void largestAlmostMissingNumber(int[] nums, int target) {
		
		int left = 0;
		int right = target;
		Map<Integer, Integer> map = new TreeMap<>();
		while(right < nums.length) {
			for(int i = left ; i <= right; i++) {
				
				if(map.containsKey(nums[i])) {

					map.put(nums[i], map.get(nums[i])+1);
				}else {

					map.put(nums[i], 1);
				}
			}
			right++;
			left++;
		}
		int minValue = Integer.MAX_VALUE;
        int largestKey = Integer.MIN_VALUE;
		System.out.println(map);
		for (int value : map.values()) {
            minValue = Math.min(minValue, value);
        }

        // Step 2: Find the largest key with the minimum value
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minValue) {
                largestKey = Math.max(largestKey, entry.getKey());
            }
        }

        System.out.println("Largest number with the least value: " + largestKey);
		
	}

}
