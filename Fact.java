package com.example.myapplication2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Fact {
    public static String get_fact(String animal) {
        OkHttpClient client = new OkHttpClient();
        String API_KEY = "0LprNJy8Da3Tq7bpc1hNww==rLPXljuPKMtR3rkH";
        String API_URL = "https://api.api-ninjas.com/v1/animals?name=" + animal;

        Request request = new Request.Builder()
                .url(API_URL)
                .header("X-Api-Key", API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            int i_slo = responseBody.indexOf("slogan");
            int i_fact = i_slo + 10;
            int i_fact_end = i_fact + responseBody.substring(i_fact).indexOf('"');
            String fact = responseBody.substring(i_fact, i_fact_end);
            return fact;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
