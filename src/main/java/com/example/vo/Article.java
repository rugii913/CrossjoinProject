package com.example.vo;

import lombok.Data;

@Data
public class Article {
	
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int boardId;
	private String title;
	private String body;	

}
