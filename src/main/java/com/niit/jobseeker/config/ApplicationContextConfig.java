package com.niit.jobseeker.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.jobseeker.model.Blog;
import com.niit.jobseeker.model.BlogLikes;
import com.niit.jobseeker.model.Event;
import com.niit.jobseeker.model.Forum;
import com.niit.jobseeker.model.ForumComment;
import com.niit.jobseeker.model.Friend;
import com.niit.jobseeker.model.Job;
import com.niit.jobseeker.model.Users;

@Configuration
@ComponentScan("com.niit.uniteup")
@EnableTransactionManagement
public class ApplicationContextConfig {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextConfig.class);

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		logger.debug("Starting of the method getOracleDataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		dataSource.setUsername("COLB_DB"); // Schema name
		dataSource.setPassword("admin");

		logger.debug("Setting the data source :" + dataSource.getConnectionProperties());
		logger.debug("Ending of the method getOracleDataSource");
		System.err.println("data base cconnected..............!");
		return dataSource;
	}

	
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		logger.debug("Starting of the method getSessionFactory");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClass(Users.class);
		  sessionBuilder.addAnnotatedClass(Blog.class);
		  sessionBuilder.addAnnotatedClass(Friend.class);
		  sessionBuilder.addAnnotatedClass(Job.class);
		  sessionBuilder.addAnnotatedClass(Forum.class);
		  sessionBuilder.addAnnotatedClass(ForumComment.class);
		 sessionBuilder.addAnnotatedClass(BlogLikes.class);
		 sessionBuilder.addAnnotatedClass(Event.class);

		logger.debug("Ending of the method getSessionFactory");
		System.err.println("session is created.............!");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		logger.debug("Starting of the method getTransactionManager");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		logger.debug("Ending of the method getTransactionManager");
		System.err.println("transction is created..............!");
		return transactionManager;
	}
}
