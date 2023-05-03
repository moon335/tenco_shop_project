package com.tenco.tencoshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tenco.tencoshop.handler.AdminInterceptor;
import com.tenco.tencoshop.handler.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/uploads/**")
				.addResourceLocations("file:///C:\\review_upload\\tenco_shop\\upload/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/cart/**").addPathPatterns("/order/**")
				.addPathPatterns("/review/insert-heart").addPathPatterns("/user/myinfoProc").addPathPatterns("/review/myReview")
				.addPathPatterns("/review/reviewInsert/**").addPathPatterns("/review/reviewUpdate/**").addPathPatterns("/review/delete/**")
				.addPathPatterns("/user/buylist").addPathPatterns("/user/questWriting").addPathPatterns("/user/myinfoEditor")
				.addPathPatterns("/user/withdraw").addPathPatterns("/user/realwithdrawal");
		
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**").addPathPatterns("/answer/**")
				.addPathPatterns("/notice/noticeForm").addPathPatterns("/notice/deleteForm").addPathPatterns("/notice/update/**")
				.addPathPatterns("/notice/delete");	
	}

} // end of class
