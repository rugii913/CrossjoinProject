package com.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDtoForLogin {
	
	private int id;
	private String email;
	private int authLevel;
	private String nickname;	
	private boolean delStatus;
	private String delDate;
	
	@Builder
	public MemberDtoForLogin(int id, String email, int authLevel, String nickname, boolean delStatus, String delDate) {
		this.id = id;
		this.email = email;
		this.authLevel = authLevel;
		this.nickname = nickname;
		this.delStatus = delStatus;
		this.delDate = delDate;
	}

}
