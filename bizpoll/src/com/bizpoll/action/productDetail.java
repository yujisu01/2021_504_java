package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.ProductDAO;
import com.bizpoll.dto.ProductDTO;

public class productDetail implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		
		String uri = "product.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		
		String parameter = request.getParameter("p_code");
		ProductDTO productDetail = pDao.listproduct(parameter);
		
		request.setAttribute("productDetail", productDetail);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath(uri);
		// false->forward방식
		forward.setRedirect(false);
		
		// forward반환
		return forward;
	}
	

}
