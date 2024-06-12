package com.wangxia.core.test.leetCode.sort;

public class HeapSort implements IArraySort{
    @Override
    public int[] sort(int[] array) {

        buildMaxHeap(array);
        int maxIndex = array.length;
        for (int i = array.length-1; i > 0; i--) {
            Util.swap(array, 0, i);
            heapify(array,0,--maxIndex);
        }

        return array;
    }


    private static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i,array.length);
        }
    }


    private static void heapify(int[] array,int index,int len) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;

        if (left < len && array[left] > array[largest]) {
            largest = left;
        }
        if (right < len && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            Util.swap(array,index,largest);
            heapify(array,largest,len);
        }
    }

    private static void heapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1)/2]) {
            Util.swap(array, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }
}
