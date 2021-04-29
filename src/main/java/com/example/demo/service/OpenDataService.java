package com.example.demo.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.example.demo.config.KeyConfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

@Service
public class OpenDataService {

    private static final String API_KEY = KeyConfig.openApiKey;
    // private static final String API_KEY ="pikPyqBgw3tFQn4GlCCkcGLnhG0S%2BDrdo676M8ePXOpPnwVKDziXnpF4H%2F%2Fc6lqBwC3RL9Kn07yfPBCzr1YHgQ%3D%3D";
    
    // https 요청시 ssl 인증서 관련 오류가 날 수 있다
    public Object getForEntity(MultiValueMap<String,String> params, String baseUrl, String path){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);

        factory.setEncodingMode(EncodingMode.NONE);
        params.add("ServiceKey", API_KEY);
        UriBuilder uri  = factory.builder().path(path).queryParams(params);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate.getForEntity(uri.build(), String.class);

        if(response.getStatusCode() == HttpStatus.OK){
            return response.getBody();
        }else{
            throw new RuntimeException();
        }
    }





    public static void main(String[] args) throws IOException {
        String API_KEY ="pikPyqBgw3tFQn4GlCCkcGLnhG0S%2BDrdo676M8ePXOpPnwVKDziXnpF4H%2F%2Fc6lqBwC3RL9Kn07yfPBCzr1YHgQ%3D%3D";

        StringBuilder urlBuilder = new StringBuilder("https://tradifood.net/api/service/TradFoodInfoService"); /*URL*/
        // urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + API_KEY); /*Service Key*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + API_KEY); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*JSON/XML*/
        URL url = new URL(urlBuilder.toString());
        System.out.println(url);



        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd = null;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

    }


}
