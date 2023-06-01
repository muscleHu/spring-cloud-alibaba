package com.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer {

    @Autowired
    ConsumerFactory consumerFactory;

    //异常处理器
    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println("消费异常："+message.getPayload());
            return null;
        };
    }

    //消息过滤器
    @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {
            //奇数被过滤
            if (Integer.parseInt(consumerRecord.value().toString()) % 2 == 0) {
                return false;
            }
            System.out.println(consumerRecord);
            System.out.println("被过滤消息："+consumerRecord.value());
            //返回true消息则被过滤
            return true;
        });
        return factory;
    }

    // 消费监听
    @KafkaListener(topics = {"testTopic"},errorHandler = "consumerAwareErrorHandler")
    public void onMessage1(ConsumerRecord<?, ?> record){
        //throw new Exception("简单消费-模拟异常");
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    }

    //消息转发
    @KafkaListener(topics = {"testTopic1"})
    @SendTo("testTopic")
    public String onMessage2(ConsumerRecord<?, ?> record) {
        return record.value()+"-额外加了一段逻辑";
    }
}
