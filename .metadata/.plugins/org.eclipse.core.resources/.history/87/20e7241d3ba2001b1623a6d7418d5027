package com.bizpoll.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;

public class LoginAct implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String url = "/login_fail.jsp";
		
		HttpSession session = request.getSession();
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pwd");
		MemberDTO mDto =null;
		
		String sql = "SELECT * "
				+ "FROM member "
				+ "WHERE id=? "
				+ "AND pwd=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mDto=new MemberDTO();
				mDto.setId(rs.getString("id"));
				mDto.setPwd(rs.getString("pwd"));
				mDto.setName(rs.getString("name"));
				mDto.setEmail(rs.getString("email"));
				mDto.setZip_num(rs.getString("zip_num"));
				mDto.setAddress(rs.getString("address"));
				mDto.setPhone(rs.getString("phone"));
				mDto.setUseyn(rs.getString("useyn"));
				mDto.setIndate(rs.getDate("indate"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		if(mDto != null) {
			session.removeAttribute("id");
			session.setAttribute("loginUser", mDto);
			url="index.bizpoll";
		}
		ActionForward forward = new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}
