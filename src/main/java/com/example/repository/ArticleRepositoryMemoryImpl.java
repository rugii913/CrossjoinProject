package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.vo.Article;

public class ArticleRepositoryMemoryImpl implements ArticleRepository {
	
	List<Article> articleList;
	
	public ArticleRepositoryMemoryImpl() {
		this.articleList = new ArrayList<>();
	}


	@Override
	public Article saveArticle(Article aritcle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticle(int id) {
		return null;
	}
	
}
