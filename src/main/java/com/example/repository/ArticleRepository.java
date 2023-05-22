package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.Article;

@Mapper
public interface ArticleRepository {

	int writeArticle(Article aritcle);
	
	Article getArticle(int id);

	List<Article> getGeneralBoardsAllArticleList(Integer articleFrom, Integer articlesPerPage);
	
	List<Article> getGeneralBoardArticleList(Integer boardId, Integer articleFrom, Integer articlesPerPage);

	void modifyArticle(Integer id, Article article);
}
