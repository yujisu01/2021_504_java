package com.bizpoll.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bizpoll.dto.BoardDTO;
import com.bizpoll.mybatis.SqlMapConfig;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	// Action에서 List로 받으니까 여기서도 List로 받음
	public List<BoardDTO> boardList(){
		sqlSession = sqlSessionFactory.openSession();
		
		List<BoardDTO> boardList = null;
		
		try {
			boardList = sqlSession.selectList("selBoardList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return boardList;
	}
	// Integer 사용한 이유: Null도 사용할수 있어서 (기초자료형 int는 null 못씀)
	// wrapper클래스와 기초자료형 사용법이 그때그때다르다
	public Integer getNewArticleNo() {
		sqlSession = sqlSessionFactory.openSession();
		
		Integer articleNo = 0;
		
		try {
			// mybatis 사용하면 articleno만 받으면됨
			articleNo = sqlSession.selectOne("getNewArticleNo");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return articleNo;
	}
	public int create(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		
		try {
			// bDto 값을 넘겨받고 주입시켜준다
			result= sqlSession.insert("createBoard", bDto);
			// auto commit이 아니므로 직접 해준다.
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}

}
