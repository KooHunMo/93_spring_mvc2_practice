package com.spring.practice.board.service;

import java.util.List;

import com.spring.practice.board.dto.BoardDto;

public interface BoardService {

	public void insertBoard(BoardDto boardDto);
	
	public List<BoardDto> getBoardList();
	
	public BoardDto getOneBoard(int num);
	
	public boolean deleteBoard(BoardDto boardDto);
	
	public boolean updateBoard(BoardDto boardDto);
}
