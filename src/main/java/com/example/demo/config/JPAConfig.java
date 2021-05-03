// package com.example.demo.config;

// import javax.persistence.EntityManagerFactory;
// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

// @Configuration
// @EnableJpaRepositories(
// 	    basePackages="com.example.demo.repository",  //repository를 관리할 패키지 명시
// 	    entityManagerFactoryRef = "entityManagerFactory", //EntityManagerFactory
// 	    transactionManagerRef = "transactionManager")
// public class JPAConfig {
//     @Bean
//     public EntityManagerFactory entityManagerFactory(@Autowired DataSource dataSource) {
//         HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//         vendorAdapter.setGenerateDdl(true);
//         vendorAdapter.setShowSql(true);
//         vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MariaDB103Dialect");
      
//         LocalContainerEntityManagerFactoryBean factory = new
//             LocalContainerEntityManagerFactoryBean();
//         factory.setJpaVendorAdapter(vendorAdapter);
//         factory.setPackagesToScan("com.example.demo.domain");
//         factory.setDataSource(dataSource);
//         factory.afterPropertiesSet();
 
//         return factory.getObject();
//     }
 
//     @Bean
//     protected JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//         return new JpaTransactionManager(entityManagerFactory);
//     }
// }
