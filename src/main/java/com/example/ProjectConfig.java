package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.controller.ArticleController;
import com.example.controller.ArticleControllerImpl_1;
import com.example.repository.ArticleRepository;
import com.example.repository.ArticleRepositoryMemoryImpl;
import com.example.service.ArticleService;

@Configuration
public class ProjectConfig {
	
	@Bean
	public ArticleController articlecontroller(ArticleService articleService) {
		
		return new ArticleControllerImpl_1(articleService); 
	}
	
	@Bean
	public ArticleRepository articleRepository() {
		
		return new ArticleRepositoryMemoryImpl(); 
	}
}
