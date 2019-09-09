package com.nlpeng.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * NO.5 增加时间戳拦截器
 * @author Ferry NLP
 * @create 2019-09-08
 * @see
 * @since 1.0v
 **/
public class TimeInterceptor implements ProducerInterceptor<String,String> {
    @Override
    public ProducerRecord<String,String> onSend(ProducerRecord record) {
        // 创建一个新的record，把时间戳写入消息体的最前部
        return new ProducerRecord<String,String>(record.topic(),record.partition(),record.timestamp(), (String) record.key(),System.currentTimeMillis()+","+record.value().toString());
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
