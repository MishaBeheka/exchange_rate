package com.dev.task.exchange.rate.model;

import lombok.Data;

@Data
public class ExchangeRate {
    private String currency;
    private Double correlation;
}
