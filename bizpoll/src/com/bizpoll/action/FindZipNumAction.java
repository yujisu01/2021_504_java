package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.AddressDAO;
import com.bizpoll.dto.AddressDTO;

public class FindZipNumAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String url = "member/findZipNum.jsp";
		
		// dong이란 애 받아옴
		String dong = request.getParameter("dong");
		// trim : 공백제거
		// 공백제거 했을때 null이아니라면
		if (dong != null && dong.trim().equals("") == false) {
			AddressDAO aDao = AddressDAO.getInstance();
			
			ArrayList<AddressDTO> addressList = 
					aDao.selectAddressByDong(dong);
			
			request.setAttribute("addressList", addressList);
			
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
