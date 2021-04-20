package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		// TODO Auto-generated method stub
		String url = "index.bizpoll";
		
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		session.removeAttribute("loginUser");
		
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}

}
