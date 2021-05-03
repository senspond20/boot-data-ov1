package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.example.demo.mapper")
public class MybatisConfig {
    @Bean
	public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        Resource mybatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*.xml");
		
		sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(mybatisConfig);
		sqlSessionFactoryBean.setMapperLocations(mapperLocations);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
