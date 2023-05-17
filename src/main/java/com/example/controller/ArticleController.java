package com.example.controller;

import java.util.List;

import org.springframework.ui.Model;

import com.example.dto.ArticleDto;

public interface ArticleController {
	
	public String viewWriteArticleWindow();
	
	public String writeArticle(ArticleDto articleData, Model model);

	public List<ArticleDto> showArticleList(Integer boardId, Integer page);
	
	public String showArticle(int id, Model model);
	
	public String viewModifyArticleWindow(int id, Model model);
	
	public String modifyArticle(Integer id, ArticleDto articleData);
	
	public void deleteArticle(int id);
}
