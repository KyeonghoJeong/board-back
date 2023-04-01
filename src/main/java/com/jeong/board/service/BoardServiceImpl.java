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
	
}
