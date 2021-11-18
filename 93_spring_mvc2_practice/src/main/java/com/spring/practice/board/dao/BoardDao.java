package com.spring.practice.board.dao;

import java.util.List;

import com.spring.practice.board.dto.BoardDto;

public interface BoardDao {
	
	public void insert(BoardDto boardDto);
	public List<BoardDto> selectAll();
}
