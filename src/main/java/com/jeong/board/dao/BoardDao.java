package com.jeong.board.dao;

import java.util.List;

import com.jeong.board.entity.BoardEntity;

public interface BoardDao {

	List<BoardEntity> getPosts();
	
}
