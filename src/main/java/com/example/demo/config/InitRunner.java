package com.example.demo.config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitRunner implements CommandLineRunner {

    private final DataSource dataSource;
    // private final KeyConfig key;
    private Logger logger = LoggerFactory.getLogger(InitRunner.class);

    @Override
    public void run(String... args) throws Exception {
        Connection conn = dataSource.getConnection();

        final DatabaseMetaData md = conn.getMetaData();
        logger.info("driver : {}", md.getDriverName());
        logger.info("url : {}", md.getURL());
        logger.info("user : {}", md.getUserName());  

        // logger.info("key : {}", key.getOpenApiKey());  
        
        logger.info("key : {}", KeyConfig.openApiKey);  
    }
    
}