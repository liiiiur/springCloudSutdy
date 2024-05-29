package com.wangxia.core.test.sort;

import java.util.Arrays;

public class MergeSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {
        int[] ints = Arrays.copyOf(array, array.length);

        sort(0,array.length-1);


        return ints;
    }

    private void sort(int low, int high) {

    }
}
