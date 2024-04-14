package com.hua.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.HashMap;

public class KafkaConsumerTest {
    public static void main(String[] args) {
        HashMap<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "huauauaa");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configMap);

        consumer.subscribe(Collections.singletonList("test"));
        while (2 > 1) {
            ConsumerRecords<String, String> data = consumer.poll(100);
            for (ConsumerRecord<String, String> item : data) {
                System.out.println(item);
            }
        }


//        consumer.close();


    }
}
