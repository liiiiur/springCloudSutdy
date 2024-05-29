package com.wangxia.core.test.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class SendMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection=factory.newConnection();
        final Channel channel=connection.createChannel();

        String message1="Hello World";

        channel.queueDeclare("test",false,false,false,null);

        DeliverCallback deliverCallback=((consumerTag, message) -> {
            System.out.println("consumerTag:"+consumerTag+" message:"+message);
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);

        });

        channel.exchangeDeclare("testExchange","direct");
        channel.queueDeclare("testQueue",false,false,false,null);

        channel.queueBind("testQueue","testExchange","test");

        channel.basicPublish("testExchange","test",null,message1.getBytes(StandardCharsets.UTF_8));

        channel.basicConsume("testQueue",false,deliverCallback,consumerTag -> {
            System.out.println("consumerTag:"+consumerTag);
        });
    }
}
