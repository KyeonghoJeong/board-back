package com.jeong.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeong.board.dao.BoardDao;
import com.jeong.board.dto.BoardDto;
import com.jeong.board.entity.BoardEntity;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Autowired
	private ModelMapper modelMapper;
	
	public List<BoardDto> getPosts(){
		List<BoardEntity> postsEntity = boardDao.getPosts();
		
		modelMapper.getConfiguration().setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setFieldMatchingEnabled(true);
		List<BoardDto> postsDto = postsEntity.stream()
				.map(post -> modelMapper.map(post, BoardDto.class))
				.collect(Collectors.toList());
	
		return postsDto;
	}

	@Override
	public BoardDto getPost(Long id) {
		// TODO Auto-generated method stub
		BoardEntity postEntity = boardDao.getPost(id);
		
		BoardDto postDto = modelMapper.map(postEntity, BoardDto.class);
		
		return postDto;
	}

	@Override
	public void postPost(BoardDto boardDto) {
		// TODO Auto-generated method stub
		BoardEntity boardEntity = modelMapper.map(boardDto, BoardEntity.class);
		
		boardDao.postPost(boardEntity);
	}

	@Override
	public void putPost(BoardDto boardDto) {
		// TODO Auto-generated method stub
		BoardEntity boardEntity = modelMapper.map(boardDto, BoardEntity.class);
		
		boardDao.putPost(boardEntity);
	}
	
	@Override
	public void deletePost(Long id) {
		// TODO Auto-generated method stub
		boardDao.deletePost(id);
	}
	
}
