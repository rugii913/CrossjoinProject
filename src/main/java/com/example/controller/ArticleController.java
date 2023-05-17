package com.example.controller;

import java.util.List;

import com.example.dto.ArticleDto;

public interface ArticleController {
	
	public void writeArticle(ArticleDto article);

	public ArticleDto showArticle(int id);
	
	public List<ArticleDto> showArticleList(Integer boardId, Integer page);

}
