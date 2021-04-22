package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class JoinAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		// TODO Auto-generated method stub
		String url = "/login.jsp";
		
		MemberDTO mDto = new MemberDTO();
		
		mDto.setId(request.getParameter("id"));
		mDto.setPwd(request.getParameter("pwd"));
		mDto.setName(request.getParameter("name"));
		mDto.setEmail(request.getParameter("email"));
		mDto.setZipNum(request.getParameter("zipNum"));
		mDto.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
		mDto.setPhone(request.getParameter("phone"));
		System.out.println("mDto ===> " + mDto.toString());
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(mDto);
		
		if(result < 0) {
			url = "/login_fail.jsp";
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
