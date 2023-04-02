package com.jeong.board.dao;

import java.util.List;

import com.jeong.board.entity.BoardEntity;

public interface BoardDao {

	List<BoardEntity> getPosts();
	BoardEntity getPost(Long id);
	void postPost(BoardEntity boardEntity);
	void putPost(BoardEntity boardEntity);
	void deletePost(Long id);
	
}
