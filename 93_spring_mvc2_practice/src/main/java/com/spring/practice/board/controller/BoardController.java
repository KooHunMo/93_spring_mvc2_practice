package com.spring.practice.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.practice.board.dto.BoardDto;
import com.spring.practice.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String main() {
		return "board/bMain";
	}
	
	@RequestMapping(value="/boardWrite" ,method=RequestMethod.GET)
	public String boardWrite() {
		return "board/bWrite"; 		
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(BoardDto boardDto) {
		System.out.println(boardDto);
		boardService.insertBoard(boardDto);
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Model model) {
		
		List<BoardDto> boardList = boardService.getBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "board/bList";
	}
	
	@RequestMapping(value="/boardInfo", method=RequestMethod.GET)
	public String boardInfo(@RequestParam("num") int num, Model model) {
			
	BoardDto boardDto = boardService.getOneBoard(num);

	model.addAttribute("boardDto", boardDto);
	
	return "board/bInfo";
		
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.GET)
	public String boardDelete(@RequestParam("num") int num, Model model) {
		
		model.addAttribute("boardDto", boardService.getOneBoard(num));
		
		return "board/bDelete";
		
	}
	@RequestMapping(value="/boardDelete", method=RequestMethod.POST)
	public String boardDelete(BoardDto boardDto, Model model) {
		
		if(boardService.deleteBoard(boardDto)) {
			model.addAttribute("success", true);
		}else {
			model.addAttribute("success", false);
		}
		return "board/bDeletePro";
		
	}
	
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.GET)
	public String boardUpdate(@RequestParam("num") int num , Model model) {
		model.addAttribute("boardDto" , boardService.getOneBoard(num));
		return "board/bUpdate";
	}
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.POST)
	public String boardUpdate(BoardDto boardDto , Model model) {
		
		if (boardService.updateBoard(boardDto)) {
			model.addAttribute("success" , true);
		}
		else {
			model.addAttribute("success" , false);
		}
		
		return "board/bUpdatePro";
	
	}
}
