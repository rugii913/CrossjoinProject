package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Article {
	
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private int boardId;
	private String 	 title;
	private String body;	
}
