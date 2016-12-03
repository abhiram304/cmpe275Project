package edu.sjsu.cmpe275.lab2.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import edu.sjsu.cmpe275.lab2.dao.BookDAO;
import edu.sjsu.cmpe275.lab2.dao.BookDAOImpl;
import edu.sjsu.cmpe275.lab2.dao.UserDAO;
import edu.sjsu.cmpe275.lab2.dao.UserDAOImpl;

import edu.sjsu.cmpe275.lab2.model.Book;
import edu.sjsu.cmpe275.lab2.model.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.sjsu.cmpe275.lab2")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Bean
	public User user(){
		User obj1=new User();
		return obj1;
	}
	
	@Bean
	public UserDAO userDAO(){
		
		return new UserDAOImpl();
	}
	
	@Bean
	public BookDAO phoneDAO(){
		
		return new BookDAOImpl();
	}
	
		
	@Bean
	public Book phone(){
		Book obj2=new Book();
		return obj2;
	}
	
	

	
	@Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

	
	/*@Bean
	
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
*/	
	
	
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
}

