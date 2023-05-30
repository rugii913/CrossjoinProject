package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.dto.MemberDtoForLogin;
import com.example.dto.Result;
import com.example.projectInnerUtil.VoDtoConvertUtil;
import com.example.repository.MemberRepository;
import com.example.vo.Member;

@Service
public class MemberService {
	
	MemberRepository memberRepository;
	VoDtoConvertUtil convertUtil;
	@Autowired
	MessageSource ms;
	
	public MemberService(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
		this.convertUtil = new VoDtoConvertUtil(memberRepository);
	}
	
	// 메서드 ----------------------------------------------------------
	// -----------------------------------------------------------------
	public Result<MemberDtoForLogin> getMemberDataByEmail(String email, String loginPw) {
		
		Member foundMember = memberRepository.getMemberByEmail(email);
		
		if (foundMember == null) {
			/* return UtilURL.historyBack("일치하는 회원 정보가 존재하지 않습니다."); */
			return new Result<MemberDtoForLogin>(null, "MemberDtoForLogin", ms.getMessage("member.login.fail.emailNotExists", null, null));
		}
			
		if (!foundMember.getLoginPw().equals(loginPw) ) {
			/* return UtilURL.historyBack("비밀번호가 일치하지 않습니다."); */
			return new Result<MemberDtoForLogin>(null, "MemberDtoForLogin", ms.getMessage("member.login.fail.loginPwMismatch", null, null));
		}
		
		MemberDtoForLogin memberDto = MemberDtoForLogin.builder()
				.id(foundMember.getId())
				.email(foundMember.getEmail())
				.authLevel(foundMember.getAuthLevel())
				.nickname(foundMember.getNickname())
				.delStatus(foundMember.isDelStatus())
				.delDate(foundMember.getDelDate())
				.build();
		
		/* return UtilURL.replace("로그인 성공!", "/main"); */
		return new Result<MemberDtoForLogin>(memberDto, "MemberDtoForLogin", ms.getMessage("member.login.success", null, null));
	}
	
	public boolean isMemberExistence(String email) {
		
		if (memberRepository.getMemberByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}
	

}
