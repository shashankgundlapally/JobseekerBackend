package com.niit.jobseeker;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.jobseeker.dao.BlogLikesDAO;
import com.niit.jobseeker.model.BlogLikes;

public class BlogLikesDAOTestCase {
	
	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static BlogLikes bloglikes;
	
	@Autowired  
	static BlogLikesDAO  blogLikesDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		bloglikes = (BlogLikes) context.getBean("bloglikes");
		blogLikesDAO = (BlogLikesDAO) context.getBean("blogLikesDAO");
	}

	
}
