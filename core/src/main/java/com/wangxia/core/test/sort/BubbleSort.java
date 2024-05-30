package com.wangxia.core.test.sort;

import java.util.Arrays;

public class BubbleSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j<array.length-i-1; j++) {
                if(array[j] > array[j+1]){
                    Util.swap(array, j, j+1);
                }
            }
        }

        return array;
    }
}
