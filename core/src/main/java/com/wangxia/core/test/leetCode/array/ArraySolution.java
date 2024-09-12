package com.wangxia.core.test.leetCode.array;

import java.util.Arrays;

public class ArraySolution {

    public static void main(String[] args) {
        String a="123";
        String d="1"+"23";
        String b=new String("123");
        String c=new String("123");
        System.out.println(a==d);
        System.out.println(c==b);
    }

    static void rotateLeft(int[] nums, int k) {
        int i=0;
        int temp1=nums[0];
        int temp2=nums[k];
        int l=nums.length;
        do{
            nums[i]=temp2;
            temp2=temp1;
            temp1=nums[(i-k+l)%l];
            i=(i-k+l)%l;
        }while(i!=0);
    }

    static void rotateRight(int[] nums, int k) {
        int beishu=k%nums.length;
        int count=nums.length%k;
        if(beishu==0){
            for(int j=0;j<count;j++){
                int i=j;
                int l=nums.length;
                int temp1=nums[i];
                int temp2=nums[l-k];
                do{
                    nums[i]=temp2;
                    temp2=temp1;
                    temp1=nums[(i+k+l)%l];
                    i=(i+k+l)%l;
                }while(i!=0);
            }
        }

        int i=0;
        int l=nums.length;
        int temp1=nums[i];
        int temp2=nums[l-k];
        do{
            nums[i]=temp2;
            temp2=temp1;
            temp1=nums[(i+k+l)%l];
            i=(i+k+l)%l;
        }while(i!=0);
    }
}
