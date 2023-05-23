package com.example.vo;

import com.example.enums.GatheringStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Gathering extends Board{
	
	private int id;
	private String regDate;
	private String startDate;
	private String endDate;
	private GatheringStatus gatheringStatus;
	private int boardId;
	private String title;
}
