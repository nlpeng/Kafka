package com.nlpeng.kafka.producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 *   自定义分区
 * @author Ferry NLP
 * @create 2019-09-07
 * @see
 * @since 1.0v
 **/
public class CustomPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        //控制分区
        return 0;//将所有数据存储到topic的第0号分区上
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
