package com.study.kafkaproducer.vo;

import lombok.Data;

@Data
public class PurchaseLogOneProduct {
    private String orderId;     //  od-0001
    private String userId;      // uid-0001
    private String productId;   // pg-0001
    private String purchasedDt; // 20230201070000
    private String price;       // 24000
}
