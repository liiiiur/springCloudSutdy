package com.wangxia.core.test.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] testArray = new int[]{45,12,35,84,24,65,1,65,3,2,23};

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertSort insertSort = new InsertSort();


        System.out.println("bubbleSort"+Arrays.toString(bubbleSort.sort(testArray)));
        System.out.println("selectionSort"+Arrays.toString(selectionSort.sort(testArray)));
        System.out.println("insertSort"+Arrays.toString(insertSort.sort(testArray)));

    }
}
