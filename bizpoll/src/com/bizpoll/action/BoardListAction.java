package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

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
		
		// 다형성 사용
		List<BoardDTO> boardList = bDao.boardList();
		
		request.setAttribute("boardList", boardList);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
