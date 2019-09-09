package com.nlpeng.kafka.stream;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

/**
 *
 * 日志处理器
 * @author Ferry NLP
 * @create 2019-09-08
 * @see
 * @since 1.0v
 **/
public class LogProcessor implements Processor<byte[], byte[]> {

    private ProcessorContext context;

    @Override
    public void init(ProcessorContext context) {
        this.context = context;
    }

    @Override
    public void process(byte[] key, byte[] value) {
        String input = new String(value);

        // 如果包含“>>>”则只保留该标记后面的内容，trim()却掉前后空格
        if (input.contains(">>>")) {
            input = input.split(">>>")[1].trim();
            // 输出到下一个topic
            context.forward("logProcessor".getBytes(), input.getBytes());
        } else {
            context.forward("logProcessor".getBytes(), input.getBytes());
        }
    }

    @Override
    public void close() {

    }
}