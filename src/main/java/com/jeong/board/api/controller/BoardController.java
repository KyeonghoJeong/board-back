package com.jeong.board.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeong.board.dto.BoardDto;
import com.jeong.board.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/api/board/get")
	public List<BoardDto> getPosts(){
		List<BoardDto> posts = boardService.getPosts();

		return posts;
	}
	
}