package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
	
	private int id;
	private String regDate;
	private String updateDate;
	private String loginId;
	private String loginPw;
	private int authLevel;
	private String name;
	private String nickname;
	private String cellphoneNum;
	private String email;
	private boolean delStatus;
	private String delDate;
}
