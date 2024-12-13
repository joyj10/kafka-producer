package com.study.kafkaproducer.config;

import com.study.kafkaproducer.util.PurchaseLogOneProductSerializer;
import com.study.kafkaproducer.util.PurchaseLogSerializer;
import com.study.kafkaproducer.util.WatchingAdLogSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaStreamsConfig {

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration myKStreamConfig() {
        Map<String, Object> myKStreamConfig = new HashMap<>();
        myKStreamConfig.put(StreamsConfig.APPLICATION_ID_CONFIG, "lecture-6");
        myKStreamConfig.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "13.125.205.11:9092, 3.36.63.75:9092, 54.180.1.108:9092");
        myKStreamConfig.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        myKStreamConfig.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        myKStreamConfig.put(StreamsConfig.producerPrefix(ProducerConfig.ACKS_CONFIG), "all");
        myKStreamConfig.put(StreamsConfig.topicPrefix(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG), 2);
        myKStreamConfig.put(StreamsConfig.NUM_STANDBY_REPLICAS_CONFIG, 1);
        return new KafkaStreamsConfiguration(myKStreamConfig);
    }


    @Bean
    public KafkaTemplate<String, Object> KafkaTemplateForGeneral() {
        return new KafkaTemplate<>(ProducerFactory());
    }

    @Bean
    public ProducerFactory<String, Object> ProducerFactory() {
        Map<String, Object> myConfig = new HashMap<>();

        myConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "13.125.205.11:9092, 3.36.63.75:9092, 54.180.1.108:9092");
        myConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        myConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, PurchaseLogOneProductSerializer.class);

        return new DefaultKafkaProducerFactory<>(myConfig);
    }

    @Bean
    public KafkaTemplate<String, Object> KafkaTemplateForWatchingAdLog() {
        return new KafkaTemplate<>(ProducerFactoryForWatchingAdLog());
    }
    @Bean
    public ProducerFactory<String, Object> ProducerFactoryForWatchingAdLog() {
        Map<String, Object> myConfig = new HashMap<>();

        myConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "13.125.205.11:9092, 3.36.63.75:9092, 54.180.1.108:9092");
        myConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        myConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, WatchingAdLogSerializer.class);

        return new DefaultKafkaProducerFactory<>(myConfig);
    }

    @Bean
    public KafkaTemplate<String, Object> KafkaTemplateForPurchaseLog() {
        return new KafkaTemplate<>(ProducerFactoryForPurchaseLog());
    }
    @Bean
    public ProducerFactory<String, Object> ProducerFactoryForPurchaseLog() {
        Map<String, Object> myConfig = new HashMap<>();

        myConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "13.125.205.11:9092, 3.36.63.75:9092, 54.180.1.108:9092");
        myConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        myConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, PurchaseLogSerializer.class);

        return new DefaultKafkaProducerFactory<>(myConfig);
    }
}
