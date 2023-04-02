package com.jeong.board.dto;

import lombok.Data;

@Data
public class BoardDto {

	private Long id;
	private String title;
	private String writer;
	private String content;
	
}