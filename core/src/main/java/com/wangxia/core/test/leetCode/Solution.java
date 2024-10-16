package com.wangxia.core.test.leetCode;


import com.wangxia.core.test.leetCode.listNode.ListNode;
import com.wangxia.core.test.leetCode.listNode.ListSolution;
import com.wangxia.core.test.leetCode.twoTree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Solution {

    public static void main(String[] args) {
        int[] arr = {0, 1};
        int i = hIndex(arr);
        System.out.println(i);
    }

    public static String reserveString(String str) {
        char[] charArray = str.toCharArray();
        reserve(charArray, 0, charArray.length - 1);
        int start = 0;
        for (int end = 0; end < charArray.length; end++) {
            if (charArray[end] == ' ') {
                reserve(charArray, start, end - 1);
                start = end + 1;
            }
        }
        reserve(charArray, start, charArray.length - 1);
        char[] chars = trimSpaces(charArray);
        return new String(chars);
    }

    private static char[] trimSpaces(char[] chars) {
        int n = chars.length;
        StringBuilder sb = new StringBuilder();

        boolean spaceFound = false;
        for (char aChar : chars) {
            if (aChar != ' ') {
                sb.append(aChar);
                spaceFound = false;
            } else if (!spaceFound) {
                sb.append(' '); // 只添加一个空格
                spaceFound = true;
            }
        }

        return sb.toString().toCharArray();
    }

    /**
     * 力扣274 H指数
     *
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count=citations.length-1;

        int h;
        return 0;
    }


    private static void reserve(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
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

    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> set = new HashSet();
        nums.forEach(x -> {
            for (int start = x.get(1); start <= x.get(2); start++) {
                set.add(start);
            }
        });
        return set.size();
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
        int l1 = -1, l2 = nums.length, i = 0;
        int num = nums[nums.length - 1];
        while (i < l2) {
            if (nums[i] < num) {
                l1++;
                Util.swap(nums, l1, i);
                i++;
            } else if (nums[i] > num) {
                --l2;
                Util.swap(nums, l2, i);
            } else {
                i++;
            }
        }
        System.out.println("l1:" + l1);
        System.out.println("l2:" + l2);

    }

}
