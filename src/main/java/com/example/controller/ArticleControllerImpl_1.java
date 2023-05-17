package com.example.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.ArticleDto;
import com.example.service.ArticleService;

@RequestMapping("/article")
public class ArticleControllerImpl_1 implements ArticleController{
	
	ArticleService articleService;
	
	public ArticleControllerImpl_1(ArticleService articleService) {
		
		this.articleService = articleService;
	}
	
	@PostMapping
	public void writeArticle(ArticleDto articleData) {
		
		
		showArticle(articleService.writeArticle(articleData));
		return;
	}

	@GetMapping("/{articleId}")
	@ResponseBody
	public ArticleDto showArticle(@PathVariable("articleId") int id) {
		
		return articleService.showArticle(id);
	}
	
	@GetMapping("/list") // http://localhost:8081/article/list?boardId=0
	public String viewArticleList(Model model, @RequestParam(required = true) Integer boardId, @RequestParam(defaultValue = "1") Integer page) {
		
		List<ArticleDto> articles = showArticleList(boardId, page);
		model.addAttribute("articles", articles);
		
		return "/usr/article/list";
	}
		
	//url 매핑 없으나, ArticleController 인터페이스 유지하기 위해 남겨놓는 부분 시작
//	@GetMapping("/list")
//	@ResponseBody
	public List<ArticleDto> showArticleList(Integer boardId, Integer page) {
		
		if (boardId == 0) {
			return articleService.showFreeboardsArticleList(page);
		}
		
		return articleService.showArticleList(boardId, page);
	}
	//url 매핑 없으나, ArticleController 인터페이스 유지하기 위해 남겨놓는 부분 끝
}
