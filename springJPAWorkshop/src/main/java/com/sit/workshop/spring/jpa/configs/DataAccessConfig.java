package com.sit.workshop.spring.jpa.configs;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScans(value = {
		@ComponentScan("com.sit.workshop.spring.jpa.cores.security") ,
		@ComponentScan("com.sit.workshop.spring.jpa.cores.immigration")
})
public class DataAccessConfig {
	@Autowired
	private Environment env;

	@Bean
	public PlatformTransactionManager transactionManager() throws PropertyVetoException {
		JpaTransactionManager transactionManager = 
			new JpaTransactionManager(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws 
			PropertyVetoException {
		
		LocalContainerEntityManagerFactoryBean factoryBean = null;
		try {
			factoryBean = new LocalContainerEntityManagerFactoryBean();
	
			// Data Source
			factoryBean.setDataSource(dataSource());
			
			// Persistence
			factoryBean.setJpaVendorAdapter(jpaVendorAdapter());			
			factoryBean.setPersistenceUnitName("springJPAPersistenceUnit");
			factoryBean.setPackagesToScan(
					  "com.sit.workshop.spring.jpa.cores.entities"
					, "com.sit.workshop.spring.jpa.cores.security.entities");
			
			String[] mappingResources = {
				 	  "sql/workshop/spring/jpa/QueryMapping.xml" ,
					  "sql/workshop/spring/jpa/security/QueryGroup.xml" ,
					  "sql/workshop/spring/jpa/immigration/QueryTravellerSearch.xml"
			};
			factoryBean.setMappingResources(mappingResources);
			
			// Keep SQL  -- Native SQL
			SQLUtils.init(mappingResources);

			// Specify JPA properties
			factoryBean.setJpaProperties(jpaProperties());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return factoryBean;
	}

	@Bean
	public DataSource dataSource() throws PropertyVetoException {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// Setting JDBC properties
		dataSource.setDriverClass(env.getProperty("database.driver"));
		dataSource.setJdbcUrl(env.getProperty("database.jdbcUrl"));
		dataSource.setUser(env.getProperty("database.username"));
		dataSource.setPassword(env.getProperty("database.password"));

        // Setting C3P0 properties
		dataSource.setAcquireIncrement(getIntProperty(env, "c3p0.acquireIncrement"));
		dataSource.setInitialPoolSize(getIntProperty(env, "c3p0.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty(env, "c3p0.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty(env, "c3p0.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty(env, "c3p0.maxIdleTime"));
		dataSource.setMaxStatements(getIntProperty(env, "c3p0.maxStatements"));
		
		return dataSource;
	}

	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
    }
	
	private Properties jpaProperties() {
		Properties props = new Properties();
		props.put(org.hibernate.cfg.Environment.JDBC_TIME_ZONE, "UTC");
		props.put(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
		props.put(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(org.hibernate.cfg.Environment.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
		props.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO,
				env.getProperty("hibernate.hbm2ddl.auto"));		
		return props;
	}

	private int getIntProperty(Environment env, String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}

}
