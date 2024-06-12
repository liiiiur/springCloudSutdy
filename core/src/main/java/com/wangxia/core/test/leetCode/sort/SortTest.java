package com.wangxia.core.test.leetCode.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {


        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertSort insertSort = new InsertSort();
        QuickSort quickSort = new QuickSort();
        HeapSort heapSort = new HeapSort();

        for (int i = 0; i < 100; i++) {

            int[] testArray = Util.generateRandomArray(100,10);
            int[] clone1 = testArray.clone();
            Arrays.sort(testArray);
            bubbleSort.sort(clone1);
            if(!Util.compare(testArray, clone1)){
                System.out.println("bubble sort failed");
                break;
            }
        }

        for (int i = 0; i < 100; i++) {

            int[] testArray = Util.generateRandomArray(100,10);
            int[] clone2 = testArray.clone();

            Arrays.sort(testArray);
            selectionSort.sort(clone2);
            if(!Util.compare(testArray, clone2)){
                System.out.println("selection sort failed");
                break;
            }
        }

        for (int i = 0; i < 100; i++) {

            int[] testArray = Util.generateRandomArray(100,10);

            int[] clone3 = testArray.clone();

            Arrays.sort(testArray);
            insertSort.sort(clone3);
            if(!Util.compare(testArray, clone3)){
                System.out.println("insert sort failed");
                break;
            }
        }

        for (int i = 0; i < 100; i++) {

            int[] testArray = Util.generateRandomArray(100,10);

            int[] clone = testArray.clone();

            Arrays.sort(testArray);
            quickSort.sort(clone
            );
            if(!Util.compare(testArray, clone)){
                System.out.println("quick sort failed");
                break;
            }
        }

        for (int i = 0; i < 100; i++) {

            int[] testArray = Util.generateRandomArray(100,10);

            int[] clone = testArray.clone();

            Arrays.sort(testArray);
            heapSort.sort(clone
            );
            if(!Util.compare(testArray, clone)){
                System.out.println("heap sort failed");
                break;
            }
        }







    }
}
