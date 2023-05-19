package com.example.vo;

import com.example.dto.BoardGroup;
import com.example.dto.BoardStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Gathering extends Board{
	
	private int id;
	private String regDate;
	private String startDate;
	private String endDate;
	private BoardStatus boardStatus;
	private BoardGroup boardGroup;
	private String title;
}
