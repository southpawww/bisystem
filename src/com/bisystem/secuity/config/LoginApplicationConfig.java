
package com.bisystem.secuity.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



import com.bisystem.dao.UserDao;
import com.bisystem.dao.UserDaoImpl;
import org.springframework.core.env.Environment;
@EnableWebMvc
@Configuration
@ComponentScan({ "com.bisystem.*" })
@Import(value = { LoginSecurityConfig.class })
@ImportResource("classpath*:applicationContext.xml")
public class LoginApplicationConfig {
	
	@Autowired
	DataSource dataSource;
	
	 @Autowired
	 private Environment environment;
	 

	 
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
	     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	     driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	     driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	     driverManagerDataSource.setUsername("marek");
	     driverManagerDataSource.setPassword("beno");
	     
	     return driverManagerDataSource;
	 }
	
	@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
	
	 @Bean
	    public UserDao userDao(){
		 UserDaoImpl empDao = new UserDaoImpl();
	       //empDao.setJdbcTemplate(jdbcTemplate());
	        return empDao;
	    }
	 /*
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.bisystem.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	       
	        return sessionFactory;
	     }
	 
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        
	        
	        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        properties.setProperty("hibernate.show_sql", "true");
	        properties.setProperty("hibernate.id.new_generator_mappings", Boolean.toString(true));
	        return properties; 
	    }
	 
	 @Bean
	 @Autowired
	 public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }

	*/
}
