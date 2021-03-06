package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class LoginAct implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String url = "/login_fail.jsp";
		
		HttpSession session = request.getSession();
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = mDao.getMember(userId, userPw);
		
		
		
		if(mDto != null) {
			if(mDto.getPwd().equals(userPw)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", mDto);
				url="index.bizpoll";
			}
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
