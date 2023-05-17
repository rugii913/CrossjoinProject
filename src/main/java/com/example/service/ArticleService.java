package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.ArticleDto;
import com.example.repository.ArticleRepository;
import com.example.projectInnerUtil.VoDtoConvertUtil;
import com.example.vo.Article;

@Service
public class ArticleService {
	
	ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
		
		this.articleRepository = articleRepository;
	}
	
	// ----------------------------------------------------------
	public int writeArticle(ArticleDto articleData) {

		return articleRepository.write(VoDtoConvertUtil.convertDtoToVo(articleData));
	}
 
	public ArticleDto showArticle(int id) {
		
		Article article = articleRepository.getArticle(id);
		return VoDtoConvertUtil.convertVoToDto(article);
	}

	public List<ArticleDto> showFreeboardsArticleList(Integer page) {
		
		List<ArticleDto> articleDataList = new ArrayList<>();
		List<Article> articleList = articleRepository.getFreeboardsArticleList(page);
		
		for (Article article : articleList) {
			articleDataList.add(VoDtoConvertUtil.convertVoToDto(article)); 
		}
		
		return articleDataList;
	}

	public List<ArticleDto> showArticleList(Integer boardId, Integer page) {
		
		return null;
	}
	
}
