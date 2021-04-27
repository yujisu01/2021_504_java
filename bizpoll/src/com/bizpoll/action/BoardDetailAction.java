package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String url = "Board/boardDetail.jsp";
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		
		System.out.println("articleNo=>>" + articleNo);
		BoardDAO bDao = new BoardDAO();
		BoardDTO bDto = bDao.boardDetail(articleNo);
		request.setAttribute("bDto", bDto);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
