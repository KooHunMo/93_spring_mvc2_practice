package com.spring.practice.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.board.dao.BoardDao;
import com.spring.practice.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao BoardDao;  // 왜 둘 다 대문자인지??
	
	@Override
	public void insertBoard(BoardDto boardDto) {
		
		BoardDao.insert(boardDto);
		
	}

	
}
