package com.example.vo;

import com.example.enums.BoardGroup;
import com.example.enums.GatheringStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Board {
	
	private int id;
	private String regDate;
	private BoardGroup boardGroup;
	private String title;
	
	Board() {
		
	}
}
