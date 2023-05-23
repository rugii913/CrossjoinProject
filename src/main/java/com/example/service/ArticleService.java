package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;
import com.example.repository.ArticleRepository;
import com.example.repository.MemberRepository;
import com.example.projectInnerUtil.VoDtoConvertUtil;
import com.example.vo.Article;

@Service
public class ArticleService {
	
	ArticleRepository articleRepository;
	MemberRepository memberRepository;
	VoDtoConvertUtil convertUtil;
	
	public ArticleService(ArticleRepository articleRepository, MemberRepository memberRepository) {
		
		this.articleRepository = articleRepository;
		this.convertUtil = new VoDtoConvertUtil(memberRepository);
	}
	
	// 메서드 ----------------------------------------------------------
	// -----------------------------------------------------------------
	public int writeArticle(ArticleDtoForWriteArticle articleData) {
		
		Article article = convertUtil.convertArticleDtoForWriteArticle(articleData);
		articleRepository.writeArticle(article);
		
		return article.getId();
	}
 
	public ArticleDto showArticle(int id) {
		
		Article article = articleRepository.getArticle(id);
		return convertUtil.convertVoToDto(article);
	}

	public List<ArticleDto> showGeneralBoardsAllArticleList(Integer page, int articlesPerPage) {
		
		int articleFrom = (page - 1) * articlesPerPage;
		
		List<ArticleDto> articleDataList = new ArrayList<>();
		List<Article> articleList = articleRepository.getGeneralBoardsAllArticleList(articleFrom, articlesPerPage);
		
		for (Article article : articleList) {
			articleDataList.add(convertUtil.convertVoToDto(article)); 
		}
		
		return articleDataList;
	}
	
	public int getCountOfGeneralBoardsAllArticle() {
		return articleRepository.getCountOfGeneralBoardsAllArticle();
	}

	public List<ArticleDto> showGeneralBoardArticleList(Integer boardId, Integer page, int articlesPerPage) {

		int articleFrom = (page - 1) * articlesPerPage;
		
		List<ArticleDto> articleDataList = new ArrayList<>();
		List<Article> articleList = articleRepository.getGeneralBoardArticleList(boardId, articleFrom, articlesPerPage);
		
		for (Article article : articleList) {
			articleDataList.add(convertUtil.convertVoToDto(article)); 
		}
		
		return articleDataList;
	}
	
	public int getCountOfGeneralBoardArticle(Integer boardId) {
		return articleRepository.getCountOfGeneralBoardArticle(boardId);
	}

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
