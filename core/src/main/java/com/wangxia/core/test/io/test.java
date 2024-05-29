package com.wangxia.core.test.io;

public class test {
    public static void main(String[] args) {
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2=="1");
        System.out.println(s3==s4);
    }

    static String s1="1";
    static String s2=new String("1");
    static String s3="1";
    static String s4=new String(s3);



    static class A{
        public void method(){
            System.out.println("A");
        }
    }

    static class B extends A{
        public void method(){
            System.out.println("B");
        }
    }
}
