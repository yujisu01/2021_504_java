package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.MemberDAO;

public class IdCheckFormAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String url="member/idcheck.jsp";
		
		String userId = request.getParameter("id");
		MemberDAO mDao = MemberDAO.getInstance();
		int message = mDao.confirmID(userId);
		
		request.setAttribute("message", message);
		request.setAttribute("id", userId);
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
