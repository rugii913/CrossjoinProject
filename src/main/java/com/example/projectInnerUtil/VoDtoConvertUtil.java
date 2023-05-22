package com.example.projectInnerUtil;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;
import com.example.repository.MemberRepository;
import com.example.vo.Article;

public class VoDtoConvertUtil {
	
	MemberRepository memberRepository;
	
	public VoDtoConvertUtil(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Article convertDtoToVo(ArticleDto articleData) {
		
		Article article = new Article(0, TimeUtil.getNowString(), TimeUtil.getNowString(), 
				articleData.getBoardGroup(), articleData.getBoardId(), articleData.getMemberId(), articleData.getTitle(), articleData.getBody());
		
		return article;
	}
	
	public Article convertArticleDtoForWriteArticle(ArticleDtoForWriteArticle articleData) {
		
		Article article = new Article(0, "", "", 
				articleData.getBoardGroup(), articleData.getBoardId(), articleData.getMemberId(), articleData.getTitle(), articleData.getBody());
		
		return article;
	}
	
	public ArticleDto convertVoToDto(Article article) {
		//TODO ArticleDTO memberNickname 가져와서 조립
		ArticleDto articleData = new ArticleDto(article.getId(), article.getRegDate(), article.getUpdateDate(),
				article.getBoardGroup(), article.getBoardId(), article.getMemberId(), article.getTitle(), article.getBody(),
				memberRepository.getMemberNicknameById(article.getMemberId()) );
		
		return articleData;
	}

}
