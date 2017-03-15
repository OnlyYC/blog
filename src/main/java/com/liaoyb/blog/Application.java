package com.liaoyb.blog;

import javassist.NotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * Application
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//定义错误页面
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return container -> {
			container.addErrorPages(
					new ErrorPage(NotFoundException.class, "/error/404"));//不同异常，不同错误页面
		};
	}
}
