package com.nlpeng.kafka.interceptor;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * No.7 主程序
 *
 * @author Ferry NLP
 * @create 2019-09-08
 * @see
 * @since 1.0v
 **/
public class InterceptorProducer {


    public static void main(String[] args) {
        //1设置配置信息
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //2构建拦截链
        List<String> interceptors = new ArrayList<>();
        interceptors.add("com.nlpeng.kafka.interceptor.TimeInterceptor");
        interceptors.add("com.nlpeng.kafka.interceptor.CounterInterceptor");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,interceptors);

        String topic = "first";
        Producer<String,String> producer = new KafkaProducer<String, String>(props);
        //3发送消息
        for (int i = 0; i <10 ; i++) {
            ProducerRecord<String,String> recond = new ProducerRecord<>(topic,"message"+i);
            producer.send(recond);
        }

        //4关闭producer，这样才会调用interceptor的close的方法
        producer.close();
    }
}
