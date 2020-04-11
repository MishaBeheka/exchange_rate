package com.dev.task.exchange_rate.controllers;

import com.dev.task.exchange_rate.model.ExchangeRate;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GettingExchangeRateController {
    private static final String USD_UAH = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=USD&tsyms=UAH";
    private static final String EUR_USD = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=EUR&tsyms=USD";
    private static final String USD_RUB = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=USD&tsyms=RUB";
    private static final String BTC_USD = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC&tsyms=USD";
    private static final String ETH_USD = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH&tsyms=USD";
    private static final String BTC_ETH = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC&tsyms=ETH";
    private static final String BTC_UAH = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC&tsyms=UAH";
    private static final List<String> URLS = new ArrayList<>();
    private static final List<ExchangeRate> EXCHANGE_RATE_LIST = new ArrayList<>();

    @GetMapping(value = "/current-exchange-rate")
    public String showExchangeRate(Model model) {
        URLS.add(USD_UAH);
        URLS.add(EUR_USD);
        URLS.add(USD_RUB);
        URLS.add(BTC_USD);
        URLS.add(ETH_USD);
        URLS.add(BTC_ETH);
        URLS.add(BTC_UAH);
        URLS.forEach(this::parseInputData);
        model.addAttribute("exchangeRateList", EXCHANGE_RATE_LIST);
        return "showExchangeRateTable";
    }

    private void parseInputData(String url) {
        try {
            URL currentURL = new URL(url);
            URLConnection connection = currentURL.openConnection();
            connection.connect();
            JsonElement element = JsonParser
                    .parseReader(new InputStreamReader((InputStream) connection.getContent()));
            String[] rate = element.toString().replaceAll("[{}\"]", "").split(":");

            ExchangeRate exchangeRate = new ExchangeRate();
            exchangeRate.setCurrency(String.format("%s%s%s", rate[0], "/", rate[1]));
            exchangeRate.setCorrelation(Double.parseDouble(rate[2]));
            EXCHANGE_RATE_LIST.add(exchangeRate);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
