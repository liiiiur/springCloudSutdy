package com.wangxia.core.test.sort;

import java.util.Arrays;

public class SelectionSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min=j;
                }
            }
            if(min!=i){
                Util.swap(array, i, min);
            }
        }
        return array;
    }
}
