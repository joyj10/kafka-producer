package com.study.kafkaproducer.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PurchaseLog {
    private String orderId;
    private String userId;
    private List<Map<String, String>> productInfo;
    private String purchasedDt;
}
