package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;
import com.example.service.ArticleService;

@Controller
@RequestMapping("/gathering")
public class GatheringController {
	
	ArticleService articleService;
	
	public GatheringController(ArticleService articleService) {
		
		this.articleService = articleService;
	}

	@GetMapping({"/main", "/", ""})
	public String viewGatheringMain() {
		
		return "/usr/gathering/gatheringMain";
	}
	
	public String viewWriteArticleWindow(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public String writeArticle(ArticleDtoForWriteArticle articleData, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ArticleDto> showArticleList(Integer boardId, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	public String showArticle(int id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public String viewModifyArticleWindow(int id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	public String modifyArticle(Integer id, ArticleDto articleData) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteArticle(int id) {
		// TODO Auto-generated method stub
		
	}

}
