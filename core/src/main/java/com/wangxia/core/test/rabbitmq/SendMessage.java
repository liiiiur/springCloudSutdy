package com.wangxia.core.test.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection=factory.newConnection();
        final Channel channel=connection.createChannel();

        channel.queueDeclare("test",false,false,false,null);

        DeliverCallback deliverCallback=((consumerTag, message) -> {
            System.out.println("test");
        });

        channel.basicConsume("test",true,deliverCallback,consumerTag -> {});
    }
}
