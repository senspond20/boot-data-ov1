package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 또는 @Component
@PropertySource("classpath:env.properties") 
public class KeyConfig {
    
    public static String openApiKey;

    @Value("${env.opendata.api_key}")
    public void setOpenApiKey(String openApiKey) {
        KeyConfig.openApiKey = openApiKey;
    }

}



/*
@Component
public class EncryptionUtil {

    @Value("${enc.key}"})
    public static String key;

}

위와 같이 작성된 EncryptionUtil 클래스 내 정의되어 있는 static 변수 key를 사용하려고 EncryptionUtil.key 로 접근을 하게 된다면 항상 null 이 반환 될 것이다. 이는 static 변수에 대하여 @Value annotation 이 동작하지 않는다.

이를 해결하기 위해서는 static 이 아닌 setter 메소드를 추가하여 static 변수에 직접적으로 값을 넣을 수 있도록 하면 된다.

예) 

@Component
public class EncryptionUtil {

    public static String key;

    @Value("${enc.key}"})
    public void setKey(String value) {
        key = value;
    }

}
*/
