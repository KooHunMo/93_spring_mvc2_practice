package com.spring.practice.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.practice.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(BoardDto boardDto) {
		
		System.out.println("----DAO----");
		System.out.println(boardDto);
		
		sqlSession.insert("mapper.BoardPracticeMapper.insertBoard", boardDto);
	}

}
