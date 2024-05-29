package com.wangxia.core.test.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] testArray = Util.generateRandomArray(100,10);
        int[] clone1 = testArray.clone();
        int[] clone2 = testArray.clone();
        int[] clone3 = testArray.clone();

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertSort insertSort = new InsertSort();
        bubbleSort.sort(clone1);
        selectionSort.sort(clone2);
        insertSort.sort(clone3);

        System.out.println("selectionSort result: "+Util.compare(clone1, clone2));
        System.out.println("insertSort result: "+Util.compare(clone1, clone3));


    }
}
