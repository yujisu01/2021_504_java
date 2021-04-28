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
	// 파라미터를 BoardDetailAction클래스의 int articleNo 받아옴
	public BoardDTO boardDetail(int articleNo) {
		// 세션객체 얻어서, Mybatis한테 호출을 해줌.
		sqlSession = sqlSessionFactory.openSession();
		BoardDTO bDto = null;
		try {
			// 객체로 담아서 파라미터로 보냄 (articleNo)
			bDto = sqlSession.selectOne("boardDetail", articleNo);
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return bDto;
		
	}public void boardDelete(int articleNo) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete("boardDelete", articleNo);
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
	}
	public int modify(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();
		
		int result=0;
		try {
			result = sqlSession.update("modifyBoard",bDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}

}
