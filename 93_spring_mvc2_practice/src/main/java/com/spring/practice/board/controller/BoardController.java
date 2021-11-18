package com.spring.practice.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.practice.board.dto.BoardDto;
import com.spring.practice.board.service.BoardService;

public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardWrite" ,method=RequestMethod.GET)
	public String boardWrite() {
		return "board/bWrite"; 		
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(BoardDto boardDto) {
		System.out.println(boardDto);
		boardService.insertBoard(boardDto);
		
		return "home";
	}
}
