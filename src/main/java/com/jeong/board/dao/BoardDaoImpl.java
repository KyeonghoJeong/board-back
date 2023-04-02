package com.jeong.board.dao;

import java.util.List;
import java.util.Optional;

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

	@Override
	public BoardEntity getPost(Long id) {
		// TODO Auto-generated method stub
		Optional<BoardEntity> boardEntity = boardRepository.findById(id);
		
		BoardEntity post = new BoardEntity();
		
		if(boardEntity.isPresent()) {
			post = boardEntity.get();
		}

		return post;
	}
	
	@Override
	public void postPost(BoardEntity boardEntity) {
		// TODO Auto-generated method stub
		boardRepository.save(boardEntity);
	}
	
	@Override
	public void putPost(BoardEntity boardEntity) {
		// TODO Auto-generated method stub
		boardRepository.save(boardEntity);
	}
	
	@Override
	public void deletePost(Long id) {
		// TODO Auto-generated method stub
		boardRepository.deleteById(id);
	}
	
}
