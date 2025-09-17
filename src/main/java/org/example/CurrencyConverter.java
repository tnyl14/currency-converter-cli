package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class CurrencyConverter {
    private static final String API_URL = "https://api.frankfurter.app/latest";
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
       fromCurrency = fromCurrency.toUpperCase();
       toCurrency = toCurrency.toUpperCase();

        Request request = new Request.Builder()
               .url(API_URL + "?from=" + fromCurrency + "&to=" + toCurrency).build();

       try (Response response = client.newCall(request).execute()) {
           if (!response.isSuccessful()) {
               throw new Exception("Unexpected code " + response);
           }
           String responseBody = response.body().string();
           ExchangeResponse exchangeResponse = objectMapper.readValue(responseBody, ExchangeResponse.class);
           Double rate = exchangeResponse.rates.get(toCurrency);

           if (rate == null ) {
               throw new IOException("Rate for " + toCurrency + " not found in response");
           }
           return rate;
       }

    }
}
