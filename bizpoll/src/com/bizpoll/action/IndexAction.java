package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.ProductDAO;
import com.bizpoll.dto.ProductDTO;

public class IndexAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		// 어디로 보낼지 정해준다. 최종으로 가야할곳.
		String uri = "index.jsp";
		
		// 상품관련 클래스
		ProductDAO pDao = ProductDAO.getInstance();
		ArrayList<ProductDTO> newProductList = pDao.listNewProduct();
		ArrayList<ProductDTO> bestProductList = pDao.listBestProduct();
		
		// 화면에서 불러올 이름이 들어갈위치
		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		ActionForward forward = new ActionForward();
		forward.setPath(uri);
		// false->forward방식
		forward.setRedirect(false);
		
		// forward반환
		return forward;
	}

}
