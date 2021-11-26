package com.spring.practice.board.dao;

import java.util.List;

import com.spring.practice.board.dto.BoardDto;

public interface BoardDao {
	
	public void insert(BoardDto boardDto);
	public List<BoardDto> selectAll();
	public BoardDto selectOne(int num);
	public BoardDto validateUserCheck(BoardDto boardDto);
	public void delete(int num);
	public void update(BoardDto boardDto);
	public void increaseReadCount(int num);
	
	
}
