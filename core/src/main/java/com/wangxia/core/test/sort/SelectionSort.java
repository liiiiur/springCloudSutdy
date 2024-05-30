package com.wangxia.core.test.sort;


public class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                 if(min > array[j]) {
                     min = array[j];
                     minIndex = j;
                 }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }
        return array;
    }
}
