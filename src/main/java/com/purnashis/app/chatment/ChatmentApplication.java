package com.purnashis.app.chatment;

import com.purnashis.app.chatment.filter.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChatmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatmentApplication.class, args);
	}

	@Bean
	FilterRegistrationBean<AuthFilter> fltrBean(){
		final FilterRegistrationBean<AuthFilter> fBean = new FilterRegistrationBean<>();
		fBean.setFilter(new AuthFilter());
		fBean.addUrlPatterns("/getfact");
		fBean.addUrlPatterns("/getfacts");
		return fBean;
	}
}
