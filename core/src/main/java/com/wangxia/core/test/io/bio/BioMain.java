package com.wangxia.core.test.io.bio;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BioMain {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//查看当前路径
        fileReaderTest();
        fileWriterTest("12454");

        int a=2;
        int b=3;
        var c=a+b;
    }

    private static void fileReaderTest() {
        try (FileReader fis = new FileReader("core\\src\\main\\resources\\docs\\io测试.txt")){
            int data;
            char[] buffer=new char[2];
            StringBuilder stringBuilder = new StringBuilder();
            while((data= fis.read(buffer))!=-1){
                System.out.println(data);
                String str = new String(buffer, 0, data);
                System.out.println(str);
                stringBuilder.append(str);
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fileWriterTest(String text) {
        try {
            FileWriter writer =new FileWriter("ouput.txt");
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
