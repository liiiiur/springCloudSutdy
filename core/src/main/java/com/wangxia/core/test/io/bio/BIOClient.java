package com.wangxia.core.test.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            socket.getOutputStream().write(scanner.nextLine().getBytes());
        }
    }
}
