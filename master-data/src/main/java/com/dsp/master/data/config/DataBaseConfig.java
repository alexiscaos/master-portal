package com.dsp.master.data.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataBaseConfig {
	 @Bean
	    public DataSource dataSource() throws PropertyVetoException {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
	        dataSource.setUrl("jdbc:mariadb://localhost:3307/maestro");
	        dataSource.setUsername("maestro");
	        dataSource.setPassword("t8komeNQecL4Xjf");
	        return dataSource;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(dataSource());
	        em.setPackagesToScan("com.dsp.master.data.model"); 
	        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
	        jpaProperties.put("hibernate.show_sql", "true");
	        jpaProperties.put("hibernate.format_sql", "true");
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
	        em.setJpaProperties(jpaProperties);
	        return em;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	        return transactionManager;
	    }
}
