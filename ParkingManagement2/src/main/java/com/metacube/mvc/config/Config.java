package com.metacube.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.mvc.filter.Myfilter;

@Configuration
public class Config {

	@Bean
	public FilterRegistrationBean<Myfilter> validationFilter() {
		FilterRegistrationBean<Myfilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new Myfilter());
		registrationBean.addUrlPatterns("/home",
				"/submitVehicleForm", "/GeneratePass", "/processCredentials", "/about",
				"/home", "/friends" , "/coworkers");

		return registrationBean;
	}
}
