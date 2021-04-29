package com.example.demo.config;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:env.properties")  
public class DataSourceConfig {
    
    @Value("${datasource.driverClassName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    private final DataSource basicDataSource(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.type(HikariDataSource.class)
                                                .driverClassName(driverClassName)
                                                .url(url)
                                                .username(username)  
                                                .password(password)
                                                .build();
        return dataSource;
    }


    @Bean(name="dataSource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource hikariConfigDataSource(){
      
        HikariConfig config = new HikariConfig();
        config.setDataSource(basicDataSource());
        // config.setAutoCommit(false);
        config.setPoolName("springHikariCP");
        config.setMaximumPoolSize(10);
        config.setMaximumPoolSize(30);
        config.setConnectionTimeout(1000);
        // config.setConnectionInitSql("SELECT 1");
        config.getConnectionTestQuery();
        
        // config.setLeakDetectionThreshold(2000);
        return new HikariDataSource(config);
    }

}