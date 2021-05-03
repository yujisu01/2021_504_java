package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		
		String url = "Board/boardList.jsp";
		BoardDAO bDao = BoardDAO.getInstance();
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		// 화면으로부터 값을 받아온다.
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
		int section = Integer.parseInt(((_section == null) ? "1" : _section));
		int pageNum = Integer.parseInt(((_pageNum == null) ? "1" : _pageNum));
		
		// 1.7이상부터 다이아몬드표기법 가능
		// String, Integer -> String, Object로 변경해줌. (다 담아주기)
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		
		pagingMap.put("searchType", searchType);
		pagingMap.put("searchKeyword",searchKeyword);
		// 다형성 사용
		// 파라미터값으로 넣어줌
		List<BoardDTO> boardList = bDao.boardList(pagingMap);
		// 호출해서 가져옴
		int boardListAllCnt = bDao.boardListAllCnt(pagingMap);
		
		// Map은 put으로 넣어준다. (request.setAttribute에서 변경)
		// 효율적으로 하려고 Map사용.
		Map<String, Object> boardInfo = new HashMap<>();
		boardInfo.put("selAllBoardList", boardList);
		// 건수
		boardInfo.put("boardListAllCnt", boardListAllCnt);
		boardInfo.put("section", section);
		boardInfo.put("pageNum", pageNum);
		boardInfo.put("searchType", searchType);
		boardInfo.put("searchKeyword", searchKeyword);
		
		// 이렇게하면 넘어갈때 이 객체하나에 한번에 다 넘어간다. (Map의 편한점)
		request.setAttribute("boardInfo", boardInfo);
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
