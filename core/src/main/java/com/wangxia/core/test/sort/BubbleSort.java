package com.wangxia.core.test.sort;

import java.util.Arrays;

public class BubbleSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {
        int[] ints = Arrays.copyOf(array, array.length);

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j<ints.length-i-1; j++) {
                if(ints[j] > ints[j+1]){
                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }

        return ints;
    }
}
