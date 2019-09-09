

##kafka 本机安装
1.在mac中安装kafka
brew install kafka

2.文件位置
/usr/local/Cellar/kafka/2.3.0
/usr/local/etc/kafka/

3.启动zookeeper
cd /usr/local/Cellar/kafka/2.3.0
bin/zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

4.启动kafka
cd /usr/local/Cellar/kafka/2.3.0
bin/kafka-server-start /usr/local/etc/kafka/server.properties

5.首先创建一个主题
bin/kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic first

6.查看
bin/kafka-topics --list --zookeeper localhost:2181

7.生产者
bin/kafka-console-producer --broker-list localhost:9092 --topic first

8.消费者
kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
    from-beginning  过往的未读消息

9.删除topic  —delete 在配置文件中需要更改配置


