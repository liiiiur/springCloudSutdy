package com.wangxia.core.test.recation.flow;


import org.reactivestreams.Subscription;

import java.util.concurrent.Flow;

public class FlowDemo {
    public static void main(String[] args) {
        Flow.Publisher publisher=new Flow.Publisher() {
            @Override
            public void subscribe(Flow.Subscriber subscriber) {

            }
        };
    }
}
