package com.example.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.ArticleDto;
import com.example.service.ArticleService;

@RequestMapping("/article/gathering")
public class GatheringControllerImpl implements GatheringController {
	
	ArticleService articleService;
	
	public GatheringControllerImpl(ArticleService articleService) {
		
		this.articleService = articleService;
	}

	@GetMapping({"/main", "/", ""})
	public String viewGatheringMain() {
		
		return "/usr/gathering/gatheringMain";
	}
	
	@Override
	public String viewWriteArticleWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String writeArticle(ArticleDto articleData, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleDto> showArticleList(Integer boardId, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showArticle(int id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewModifyArticleWindow(int id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyArticle(Integer id, ArticleDto articleData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(int id) {
		// TODO Auto-generated method stub
		
	}

}
