package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.vo.Article;

@Component
public interface ArticleRepository {

	int write(Article aritcle);
	
	Article getArticle(int id);

	List<Article> getFreeboardsArticleList(Integer page);

	void modifyArticle(Integer id, Article article);
}
