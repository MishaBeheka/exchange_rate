package com.dev.task.exchange_rate.model;

import lombok.Data;

@Data
public class ExchangeRate {
    private String currency;
    private Double correlation;
}
