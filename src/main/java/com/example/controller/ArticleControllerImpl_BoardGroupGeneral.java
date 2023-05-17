package com.example.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ArticleDto;
import com.example.service.ArticleService;

@RequestMapping("/article/general")
public class ArticleControllerImpl_BoardGroupGeneral implements ArticleController{
	
	ArticleService articleService;
	
	public ArticleControllerImpl_BoardGroupGeneral(ArticleService articleService) {
		
		this.articleService = articleService;
	}
	
	@GetMapping("/write")
	@Override
	public String viewWriteArticleWindow() {
		// TODO Auto-generated method stub
		return "/usr/article/general/write";
	}
	
	@PostMapping("/write")
	@Override
	public String writeArticle(ArticleDto articleData, Model model) {
		
		int id = articleService.writeArticle(articleData);
		return showArticle(id, model);
	}
	
	@GetMapping // http://localhost:8081/article?boardId=0
	public String viewArticleList(Model model, @RequestParam(defaultValue = "0") Integer boardId, @RequestParam(defaultValue = "1") Integer page) {
		
		List<ArticleDto> articles = showArticleList(boardId, page);
		model.addAttribute("articles", articles);
		
		return "/usr/article/general/list";
	}
	
	//url 매핑 없으나, ArticleController 인터페이스 유지하기 위해 남겨놓는 부분 시작 - viewArticleList 관련
//	@GetMapping("/list")
//	@ResponseBody
	@Override
	public List<ArticleDto> showArticleList(Integer boardId, Integer page) {
		
		if (boardId == 0) {
			return articleService.showFreeboardsArticleList(page);
		}
		
		return articleService.showArticleList(boardId, page);
	}
	//url 매핑 없으나, ArticleController 인터페이스 유지하기 위해 남겨놓는 부분 끝 - viewArticleList 관련

	@GetMapping("/{articleId}")
	@Override
	public String showArticle(@PathVariable("articleId") int id, Model model) {
		
		ArticleDto articleData = articleService.showArticle(id);
		model.addAttribute("articleData", articleData);
		
		return "/usr/article/general/detail";
	}
	
	@GetMapping("/{articleId}/modify")
	@Override
	public String viewModifyArticleWindow(@PathVariable("articleId") int id, Model model) {
		
		ArticleDto articleData = articleService.showArticle(id);
		model.addAttribute("articleData", articleData);
		
		return "/usr/article/general/modify";
	}
	
	@PostMapping("/{articleId}/modify")
	@Override
	public String modifyArticle(@PathVariable("articleId") Integer id, ArticleDto articleData) {
		
		if (id == null) {
			return null;
		} else if (id != articleData.getId()) {
			return null;
		}
		// TODO url articleId와 articleData의 id 검증 수정
		articleService.modifyArticle(id, articleData);
		
		return "redirect:/article/{articleId}";
	}
	
	@PostMapping("/{articleId}/delete")
	@Override
	public void deleteArticle(@PathVariable("articleId") int id) {
		
		// TODO boardId 저장해서 리다이렉트 되도록 수정
		articleService.deleteArticle(id);
		return;
	}	

}
