package com.wangxia.core.test.sort;

import java.util.Arrays;

public class SelectionSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {
        int[] ints = Arrays.copyOf(array, array.length);

        for (int i = 0; i < ints.length; i++) {
            int min = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[min] > ints[j]) {
                    min=j;
                }
            }
            if(min!=i){
                int temp = ints[i];
                ints[i] = ints[min];
                ints[min] = temp;
            }
        }
        return ints;
    }
}
