package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException;
}
