package com.study.kafkaproducer.vo;

import lombok.Data;

import java.util.List;

@Data
public class WatchingAdLog {
    private String userId;
    private String productId;   // pg-001
    private String adId;        // ad-101
    private String adType;
    private String watchingTime; // 머문 시간
    private String watchingDt;  // 20241201010000
}
