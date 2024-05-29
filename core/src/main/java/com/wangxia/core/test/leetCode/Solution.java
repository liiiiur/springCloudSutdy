package com.wangxia.core.test.leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] difficulty = {1,3,5,6};
        
        int[] a=new int[5];
        int[][] b=new int[5][];
        a[2]=2;



        int maxProfit = searchInsert(difficulty,2);
        System.out.println(maxProfit);

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    mid = (left + mid) / 2;
                } else {
                    mid = (mid + right) / 2;
                }
            }
        }
        return mid;

    }

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * num + nums[i] == sum) {
                return i;
            }
            num += nums[i];
        }
        return -1;
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerIntegerHashMap.containsKey(target - nums[i])) {
                return new int[]{integerIntegerHashMap.get(target - nums[i]), i};
            }
            integerIntegerHashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        // 将 difficulty 和 profit 组合成 jobs 数组
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // 按照工作难度排序，如果难度相同则按收益排序
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // 对工人的能力进行排序
        Arrays.sort(worker);

        int maxProfit = 0;
        int bestProfit = 0;
        int j = 0;

        // 遍历每个工人cc
        for (int ability : worker) {
            // 找到当前工人能完成的最大收益工作
            while (j < n && jobs[j][0] <= ability) {
                bestProfit = Math.max(bestProfit, jobs[j][1]);
                j++;
            }
            // 累积总收益
            maxProfit += bestProfit;
        }

        return maxProfit;
    }


}
