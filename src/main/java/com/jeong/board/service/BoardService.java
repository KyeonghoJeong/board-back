package com.jeong.board.service;

import java.util.List;

import com.jeong.board.dto.BoardDto;

public interface BoardService {
	
	List<BoardDto> getPosts();
	BoardDto getPost(Long id);
	void postPost(BoardDto boardDto);
	void putPost(BoardDto boardDto);
	void deletePost(Long id);
	
}
