package com.example.repository;

import java.util.List;

import com.example.vo.Article;

public interface ArticleRepositoryDBInterface extends ArticleRepository{
	
	@Override
	public int writeArticle(Article aritcle);
	
	@Override
	public Article getArticle(int id);

	@Override
	public List<Article> getFreeboardsArticleList(Integer page);

	@Override
	public void modifyArticle(Integer id, Article article);

	//-----------------------------------------------------------------------------------------------
	public void writeArticle(int memberId, int boardId, String title, String body);
	
	public List<Article> getArticles();

	
	
	public List<Article> getForPrintAllArticles(int articleFrom, int articlesPerPage, String searchKeywordTypeCode, String searchKeyword);
	
	public List<Article> getForPrintArticles(Integer boardId, int articleFrom, int articlesPerPage, String searchKeywordTypeCode, String searchKeyword);
	
	public int getAllArticlesCount(String searchKeywordTypeCode,String searchKeyword);
	
	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword);
	
	public Article getForPrintArticle(int id);
	
	public void deleteArticle(int id);

	public void modifyArticle(int id, String title, String body);
	
	public int getLastInsertId();

//	어떻게 반환값 int로 받아올 수 있는지 알아볼 것 -> UPDATE, DELETE, INSERT는 원래 affectedRow 개수를 반환함
	public int increaseHitCount(int id);
	
	public int getArticleHitCount(int id);

	public void increaseLike(int id);

//	public int getSumReactionPointByMemberId(int actorId, int id);
	
	public int increaseGoodReactionPoint(int relId);

	public int increaseBadReactionPoint(int relId);

//	public int cancelReactionPoint(int relId);

	public int cancelGoodReactionPoint(int relId);

	public int cancelBadReactionPoint(int relId);
	
}
