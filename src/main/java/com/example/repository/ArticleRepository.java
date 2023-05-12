package com.example.repository;

import org.springframework.stereotype.Component;

import com.example.vo.Article;

@Component
public interface ArticleRepository {

	Article saveArticle(Article aritcle);
	
	Article getArticle(int id);
	
}
