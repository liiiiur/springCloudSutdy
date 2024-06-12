package com.wangxia.core.test.leetCode.sort;

public class QuickSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {
        return quickSort(sourceArray, 0, sourceArray.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] partition = partition(arr, left, right);
            quickSort(arr, left, partition[0]);
            quickSort(arr,partition[1] , right);
        }
        return arr;
    }

    private int[] partition(int[] arr, int left, int right) {
        int pivot = arr[right],l1 = left-1,l2 = right,i=left;
        while (i<l2){
            if(arr[i]<pivot){
                Util.swap(arr,++l1,i++);
            }else if(arr[i]>pivot){
                Util.swap(arr,--l2,i);
            }else {
                i++;
            }
        }
        Util.swap(arr,l2,right);
        return new int[]{l1,l2};
    }


}