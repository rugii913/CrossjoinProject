package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDto {
	
	private int id;
	private String regDate;
	private String updateDate;
	private BoardGroup boardGroup;
	private int boardId;
	private int memberId;
	private String title;
	private String body;	
	//
	private String memberNickname;

}
