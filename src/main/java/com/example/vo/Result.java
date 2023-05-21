package com.example.vo;

import lombok.Getter;

public class Result<T> {

	@Getter
	private T data1;
	@Getter
	private String data1Name;
	
	public Result(T data1, String data1Name) {
		this.data1 = data1;
		this.data1Name = data1Name;
	}

}
