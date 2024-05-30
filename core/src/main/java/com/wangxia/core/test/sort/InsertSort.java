package com.wangxia.core.test.sort;

import java.util.Arrays;

public class InsertSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {


        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    Util.swap(array, j, j + 1);
                }
            }
        }

        return array;

    }
}
