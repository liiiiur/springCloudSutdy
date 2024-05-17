package com.wangxia.core.test.leetCode;

import java.util.HashMap;

public class Solution {
    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(integerIntegerHashMap.containsKey(target - nums[i])){
                return new int[]{integerIntegerHashMap.get(target - nums[i]), i};
            }
            integerIntegerHashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
