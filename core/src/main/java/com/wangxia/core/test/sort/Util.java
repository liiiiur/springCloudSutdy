package com.wangxia.core.test.sort;

public class Util {
    public static void swap(int[] arr, int i, int j) {
        if (i == j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }else {
            arr[i] = arr[i]^arr[j];
            arr[j] = arr[i]^arr[j];
            arr[i] = arr[i]^arr[j];
        }

    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * (maxValue+1))-(int)(Math.random()*maxValue));
        }
        return arr;
    }

    public static boolean compare(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length){return false;}
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
