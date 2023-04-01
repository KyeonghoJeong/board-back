package com.jeong.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.jeong.board.entity.BoardEntity;
import com.jeong.board.repository.BoardRepository;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private BoardRepository boardRepository;
	
	public List<BoardEntity> getPosts(){
		List<BoardEntity> posts = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		
		return posts;
	}
	
}
