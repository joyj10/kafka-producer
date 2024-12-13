package com.study.kafkaproducer.service;

import com.study.kafkaproducer.config.KafkaStreamsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    KafkaStreamsConfig kafkaConfig;

    String topicName = "defaultTopic";

    private KafkaTemplate<String, Object> kafkaTemplate;
    public void pub(String msg) {
        kafkaTemplate = kafkaConfig.KafkaTemplateForGeneral();
        kafkaTemplate.send(topicName, msg);
    }

    public void sendJoinedMsg (String topicNm, Object msg) {
        kafkaTemplate = kafkaConfig.KafkaTemplateForGeneral();
        kafkaTemplate.send(topicNm, msg);
    }
    public void sendMsgForWatchingAdLog (String topicNm, Object msg) {
        kafkaTemplate = kafkaConfig.KafkaTemplateForWatchingAdLog();
        kafkaTemplate.send(topicNm, msg);
    }

    public void sendMsgForPurchaseLog (String topicNm, Object msg) {
        kafkaTemplate = kafkaConfig.KafkaTemplateForPurchaseLog();
        kafkaTemplate.send(topicNm, msg);
    }
}
