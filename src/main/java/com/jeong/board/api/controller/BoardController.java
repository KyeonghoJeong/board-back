package com.jeong.board.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeong.board.dto.BoardDto;
import com.jeong.board.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/api/board/get/posts")
	public List<BoardDto> getPosts(){
		List<BoardDto> posts = boardService.getPosts();

		return posts;
	}
	
	@GetMapping("/api/board/get/post")
	public BoardDto getPost(@RequestParam("id") Long id) {
		BoardDto post = boardService.getPost(id);

		return post;
	}
	
	@PostMapping("api/board/post")
	public void postPost(@RequestBody BoardDto boardData) {
		BoardDto boardDto = new BoardDto();
		
		boardDto.setTitle(boardData.getTitle());
		boardDto.setWriter(boardData.getWriter());
		boardDto.setContent(boardData.getContent());
		
		boardService.postPost(boardDto);
	}
	
	@PutMapping("api/board/put")
	public void putPost(@RequestBody BoardDto boardDto) {
		boardService.putPost(boardDto);
	}
	
	@DeleteMapping("api/board/delete")
	public void deletePost(@RequestParam("id") Long id) {
		boardService.deletePost(id);
	}
	
}