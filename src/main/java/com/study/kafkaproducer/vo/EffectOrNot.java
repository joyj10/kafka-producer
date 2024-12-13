package com.study.kafkaproducer.vo;

import lombok.Data;

import java.util.Map;

@Data
public class EffectOrNot {
    private String adId;
    private String userId;
    private String orderId;
    private Map<String, String> productInfo;
}
