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
		
		// 조회하기 위해 articleNo를 받아온다. 
		// Integer.parseInt를 안해주면 타입이 안맞어서 오류가..
		// 객체->기초, 기초->객체 Wrapper클래스 사용 (기초->기초 캐스팅 사용)
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		
		BoardDAO bDao = new BoardDAO();
		// articleNo를 호출해서, bDto객체에 담았다.
		BoardDTO bDto = bDao.boardDetail(articleNo);
		
		System.out.println("bDto ====>" + bDto.toString());
		
		// 화면에 보여주기 위해 하나하나 안담고, DTO객체로 다 담아서 보여줌
		// 그래서 DTO객체 생성했음
		request.setAttribute("bDto", bDto);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
