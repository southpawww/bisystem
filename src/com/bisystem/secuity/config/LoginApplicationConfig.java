
package com.bisystem.secuity.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



import com.bisystem.dao.UserDao;
import com.bisystem.daoimpl.UserDaoImpl;
import com.bisystem.model.User;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.bisystem.*" })
@Import(value = { LoginSecurityConfig.class })
public class LoginApplicationConfig {
	
	@Autowired
	DataSource dataSource;
	
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
	    public LocalSessionFactoryBean SessionFactory(DataSource dataSource) {
	       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        hibernateProperties.setProperty("hibernate.show_sql", "true");
	       
	        sessionFactory.setDataSource(dataSource);
	        sessionFactory.setHibernateProperties(hibernateProperties);
	      
	        sessionFactory.setAnnotatedClasses(User.class);
	       

	        return sessionFactory;
	    }
	*/
	 

	
}
