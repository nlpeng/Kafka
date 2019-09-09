package com.nlpeng.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 *
 * No.6 统计发送消息成功和发送失败消息数，并在producer关闭时打印这两个计数器
 * @author Ferry NLP
 * @create 2019-09-08
 * @see
 * @since 1.0v
 **/
public class CounterInterceptor implements ProducerInterceptor<String,String> {

    private int errorCounter = 0;
    private int successCounter = 0;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        //统计成功和失败的次数
        if(exception==null){
            successCounter++;
        }else {
            errorCounter++;
        }
    }

    @Override
    public void close() {
        //保存结果
        System.out.println("Successful sent:"+successCounter);
        System.out.println("Failed sent:"+ errorCounter);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
