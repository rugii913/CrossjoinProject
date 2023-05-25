package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.MemberDtoForSession;
import com.example.projectInnerUtil.VoDtoConvertUtil;
import com.example.repository.MemberRepository;
import com.example.vo.Member;

@Service
public class MemberService {
	
	MemberRepository memberRepository;
	VoDtoConvertUtil convertUtil;
	
	public MemberService(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
		this.convertUtil = new VoDtoConvertUtil(memberRepository);
	}
	
	// 메서드 ----------------------------------------------------------
	// -----------------------------------------------------------------
	public MemberDtoForSession getMemberDataByEmail(String email) {
		
		Member foundMember = memberRepository.getMemberByEmail(email);
		MemberDtoForSession memberData = MemberDtoForSession.builder()
				.id(foundMember.getId())
				.email(foundMember.getEmail())
				.authLevel(foundMember.getAuthLevel())
				.nickname(foundMember.getNickname())
				.delStatus(foundMember.isDelStatus())
				.delDate(foundMember.getDelDate())
				.build();
		
		return memberData;
	}
	

}
