package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.MemberDtoForLogin;
import com.example.dto.Result;
import com.example.projectInnerUtil.UtilURL;
import com.example.repository.MemberRepository;
import com.example.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	MemberService memberService;
	MemberRepository memberRepository;
	@Autowired
	MessageSource ms;
	
	public MemberController(MemberService memberService, MemberRepository memberRepository) {

		this.memberService = memberService;
		this.memberRepository = memberRepository;
	}
	
//	@GetMapping({"", "/main", "/home/main"})
//	public String showMain(HttpServletRequest request, Model model) {
//		
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//			model.addAttribute("loginedMember", null);
//			return "/main";
//		}
//		
//		Member loginedMember = (Member)session.getAttribute("loginedMember");
//		model.addAttribute("loginedMember", loginedMember);
//		
//		return "/main";
//	}

	@GetMapping("/getLoginedMemberNickname")
	@ResponseBody
	public Result<String> getLoginedMemberNickname(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("loginedMember") == null) {
			return new Result<String>(null, "loginedMemberNickname", "로그인 중이 아닙니다");
		}
		
		MemberDtoForLogin loginedMember = (MemberDtoForLogin)session.getAttribute("loginedMember");
		log.info("loginedMember = {}", loginedMember);
		
		return new Result<String>(loginedMember.getNickname(), "loginedMemberNickname", "성공");
				
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Result<MemberDtoForLogin> login(@RequestParam String email, @RequestParam String loginPw, HttpServletRequest request) {
		
		Result<MemberDtoForLogin> result = memberService.getMemberDataByEmail(email, loginPw);
		
		if (result.getData1() == null) {
			return result;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginedMember", result.getData1());
		session.setAttribute("logined", true);
		
		/* return UtilURL.replace("로그인 성공!", "/main"); */
		return result;
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		return UtilURL.replace("로그아웃 성공!", "/main");
	}
	
	@PostMapping("/join")
	@ResponseBody
	public Result<String> doJoin(String email, String loginPw, String nickname, HttpServletResponse response) {
		
		if (memberRepository.getMemberByEmail(email) != null) {
			return new Result<String>(nickname, "JoinedMemberNickname", ms.getMessage("member.join.fail.emailDuplicated", null, null));
		}
		
		System.out.println(email);
		System.out.println(loginPw);
		if (loginPw == null || loginPw.equals("")) {
			return new Result<String>(nickname, "JoinedMemberNickname", ms.getMessage("member.join.fail.loginPwNotInserted", null, null));
		} else if (loginPw.trim().length() < 5) {
			return new Result<String>(nickname, "JoinedMemberNickname", ms.getMessage("member.join.fail.loginPwBelowFive", null, null));
		} else if (loginPw.contains(" ")) {
			return new Result<String>(nickname, "JoinedMemberNickname", ms.getMessage("member.join.fail.loginPwContainsSpacing", null, null));
		}
		
		memberRepository.join(email, loginPw, nickname);
		
		return new Result<String>(nickname, "JoinedMemberNickname", ms.getMessage("member.join.success", null, null));
	}
	
	@GetMapping("/checkDupEmail")
	@ResponseBody
	public String checkDupEmail(String email) {
		
		if (memberRepository.getMemberByEmail(email) == null) {
			return "Y";
		}
		return "N";
	}
}
