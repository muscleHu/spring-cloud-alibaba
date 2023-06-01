package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/kafkaProduct")
public class KafkaProductCtrl {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息
    @GetMapping("/send/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("testTopic1", "1", message).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            System.out.println("发送消息失败:" + failure.getMessage());
        });
        /*kafkaTemplate.send("testTopic", message).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("发送消息失败："+ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
            }
        });*/
    }

    @GetMapping("/sendByTranscation/{message}")
    public void sendMessageByTranscation(@PathVariable("message") String message) {
        kafkaTemplate.executeInTransaction(operations -> {
            operations.send("testTopic1","test executeInTransaction");
            throw new RuntimeException("fail");
        });
    }

}
