package com.example.vo;

import com.example.dto.BoardGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Board {
	
	private int id;
	private String regDate;
	private BoardGroup boardGroup;
	private String title;
}
