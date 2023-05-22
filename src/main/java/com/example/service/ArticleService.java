package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;
import com.example.repository.ArticleRepository;
import com.example.projectInnerUtil.VoDtoConvertUtil;
import com.example.vo.Article;

@Service
public class ArticleService {
	
	ArticleRepository articleRepository;
	VoDtoConvertUtil convertUtil;
	
	public ArticleService(ArticleRepository articleRepository) {
		
		this.articleRepository = articleRepository;
		this.convertUtil = new VoDtoConvertUtil();
	}
	
	// 메서드 ----------------------------------------------------------
	// -----------------------------------------------------------------
	public int writeArticle(ArticleDtoForWriteArticle articleData) {

		return articleRepository.writeArticle(convertUtil.convertArticleDtoForWriteArticle(articleData));
	}
 
	public ArticleDto showArticle(int id) {
		
		Article article = articleRepository.getArticle(id);
		return convertUtil.convertVoToDto(article);
	}

	// 조정 필요 부분 시작
	public List<ArticleDto> showGeneralBoardsAllArticleList(Integer page) {
		
		int articlesPerPage = 10;
		int articleFrom = (page - 1) * articlesPerPage;
		
		List<ArticleDto> articleDataList = new ArrayList<>();
		List<Article> articleList = articleRepository.getGeneralBoardsAllArticleList(articleFrom, articlesPerPage);
		
		for (Article article : articleList) {
			articleDataList.add(convertUtil.convertVoToDto(article)); 
		}
		
		return articleDataList;
	}

	public List<ArticleDto> showGeneralBoardArticleList(Integer boardId, Integer page) {

		int articlesPerPage = 10;
		int articleFrom = (page - 1) * articlesPerPage;
		
		List<ArticleDto> articleDataList = new ArrayList<>();
		List<Article> articleList = articleRepository.getGeneralBoardArticleList(boardId, articleFrom, articlesPerPage);
		
		for (Article article : articleList) {
			articleDataList.add(convertUtil.convertVoToDto(article)); 
		}
		
		return articleDataList;
	}
	// 조정 필요 부분 끝	

	public void modifyArticle(Integer id, ArticleDto articleData) {
		// TODO Auto-generated method stub
		Article article = convertUtil.convertDtoToVo(articleData);
		articleRepository.modifyArticle(id, article);
		return;
	}
	
	public void deleteArticle(int id) {
		// TODO Auto-generated method stub
	}

}
