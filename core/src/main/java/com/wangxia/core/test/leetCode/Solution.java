package com.wangxia.core.test.leetCode;

import com.wangxia.core.test.sort.QuickSort;
import com.wangxia.core.test.sort.Util;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] difficulty = Util.generateRandomArray(10, 10);
        int[] ll = new int[]{1, 11,6,4,8,6, 5,2,8,5,7, 9, 5, 4, 6};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(ll);
        System.out.println(Arrays.toString(ll));

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

    private static void helanSort(int[] nums) {
        int l1 = -1, l2 = nums.length,i=0;
        int num=nums[nums.length-1];
        while (i < l2) {
            if(nums[i]<num){
                l1++;
                Util.swap(nums, l1, i);
                i++;
            }else if(nums[i]>num){
                --l2;
                Util.swap(nums, l2, i);
            }else {
                i++;
            }
        }
        System.out.println("l1:"+l1);
        System.out.println("l2:"+l2);

    }

}
