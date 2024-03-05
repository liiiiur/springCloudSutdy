package com.wangxia.core.core.io.bio;

import com.sun.tools.javac.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BioMain {
    public static void main(String[] args) {
        fileReaderTest();
    }

    private static void fileReaderTest() {
        try (FileReader fis = new FileReader("D:\\Java\\Project\\springCloudSutdy\\core\\src\\main\\resources\\doc\\io测试.txt")){
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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
