package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
import com.bizpoll.dao.MemDAO;
import com.bizpoll.dto.MemberDTO;*/

public class LoginAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String uri = "login.jsp";
		
		/*
		 * MemberDAO mDao = MemberDAO.getInstance();
		 * 
		 * String parameter = request.getParameter("id"); MemberDTO member =
		 * mDao.loginlist("id","pwd"); request.setAttribute("LoginAction",member );
		 */
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(uri);
		// false->forward방식
		forward.setRedirect(false);
		
		return forward;
	}

}
