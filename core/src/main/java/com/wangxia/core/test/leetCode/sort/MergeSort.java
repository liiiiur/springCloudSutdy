package com.wangxia.core.test.leetCode.sort;

public class MergeSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {
        sort(0,array.length-1);
        return array;
    }

    private void sort(int low, int high) {

    }
}
