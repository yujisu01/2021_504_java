package com.bizpoll.action;

public class ActionForward {
	// 응답할 페이지주소 경로
	private String path;
	
	// true → sendRedirect,   false → forward
	private boolean isRedirect;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
