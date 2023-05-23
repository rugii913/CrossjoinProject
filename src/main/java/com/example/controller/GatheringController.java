package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;
import com.example.projectInnerUtil.UtilURL;
import com.example.repository.MemberGatheringRepository;
import com.example.service.ArticleService;
import com.example.vo.Member;

@Controller
@RequestMapping("/gathering")
public class GatheringController {
	
	ArticleService articleService;
	MemberGatheringRepository memberGatheringRepository;
	
	
	public GatheringController(ArticleService articleService, MemberGatheringRepository memberGatheringRepository) {
		
		this.articleService = articleService;
		this.memberGatheringRepository = memberGatheringRepository;
	}

	@GetMapping({"/main", "/", ""})
	public String viewGatheringMain() {
		
		return "/usr/gathering/gatheringMain";
	}
	
	@GetMapping("{gatheringId}")
	public String viewEachGathering(@PathVariable int gatheringId, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Member loginedMember = (Member)request.getSession().getAttribute("loginedMember");
		if (loginedMember == null) {
			
			return UtilURL.setContentTypeAndHistoryBack("권한이 없습니다.", response);
		}
		
		int loginedMemberId = loginedMember.getId();
		
		int authority = memberGatheringRepository.estimateAuthority(loginedMemberId, gatheringId);
		System.out.println(authority);
		System.out.println(authority);
		System.out.println(authority);
		
		if (authority != 1) {
			
			return UtilURL.setContentTypeAndHistoryBack("권한이 없습니다.", response);
		}
		
		return "/usr/gathering/gatheringTmp" + gatheringId;
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
