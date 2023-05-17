package com.example.projectInnerUtil;

import com.example.dto.ArticleDto;
import com.example.repository.ArticleRepositoryMemoryImpl;
import com.example.vo.Article;

public class VoDtoConvertUtil {
	
	public static Article convertDtoToVo(ArticleDto articleData) {
		
		Article article = new Article(++ArticleRepositoryMemoryImpl.lastArticleId, TimeUtil.getNowString(), TimeUtil.getNowString(), 
				articleData.getMemberId(), articleData.getBoardId(), articleData.getTitle(), articleData.getBody());
		
		return article;
	}
	
	public static ArticleDto convertVoToDto(Article article) {
		
		ArticleDto articleData = new ArticleDto(article.getId(), article.getRegDate(), article.getUpdateDate(),
				article.getMemberId(), article.getBoardId(), article.getTitle(), article.getBody());
		
		return articleData;
	}

}
