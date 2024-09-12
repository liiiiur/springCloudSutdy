package com.wangxia.core.test.recation.flow;

import org.reactivestreams.Subscription;

import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        //1.接收一个参数，返回一个结果
        Function<String,Integer> function=(x)->{
            System.out.println(x);
            return 1;
        };

        function.apply("hello");

        //2.一个入参，无返回值
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("hello"); // 输出: hello




    }
}
