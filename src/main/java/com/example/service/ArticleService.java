package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repository.ArticleRepository;
import com.example.vo.Article;

@Service
public class ArticleService {
	
	ArticleRepository articleRepository;
	
	
	public ArticleService(ArticleRepository articleRepository) {
		
		this.articleRepository = articleRepository;
	}

	
	public Article writeArticle(Article article) {

		return articleRepository.saveArticle(article);
	}
 
	public Article showArticle(int id) {
		
		return articleRepository.getArticle(id);
	}
	
}
