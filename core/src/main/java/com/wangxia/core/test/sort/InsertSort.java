package com.wangxia.core.test.sort;

import java.util.Arrays;

public class InsertSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {
        int[] ints = Arrays.copyOf(array, array.length);

        for (int i = 1; i < ints.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }

        return ints;

    }
}
