package com.spring.practice.board.dao;

import java.util.List;

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
		
		sqlSession.insert("mapper.BoardPracticeMapper.insertBoard", boardDto);
	}

	@Override
	public List<BoardDto> selectAll() {
		
		return sqlSession.selectList("mapper.BoardPracticeMapper.getAllBoard");
	}

	@Override
	public BoardDto selectOne(int num) {
		
		return sqlSession.selectOne("mapper.BoardMapper.getOneBoard,num");
	}

	@Override
	public BoardDto validateUserCheck(BoardDto boardDto) {
		
		return sqlSession.selectOne("mapper.BoardMapper.validateUserCheck",boardDto);
	}

	@Override
	public void delete(int num) {
		
		sqlSession.delete("mapper.BoardMapper.deleteBoard,num");
		
	}

	@Override
	public void update(BoardDto boardDto) {
		sqlSession.update("mapper.BoardMapper.updateBoard,num");
		
	}

	@Override
	public void increaseReadCount(int num) {
		sqlSession.update("mapper.BoardMapper.increaseReadCount", num);
		
	}

}
