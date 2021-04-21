package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;
// 이거는 내가 작성한 MemberDAO클래스
public class MemDAO {
	// 나만이 생성할수 있다. (싱글톤 패턴)
	// 외부에서 new로 생성할수 없다.
	private MemDAO() {
		
	}
	private static MemDAO instance = new MemDAO();
	
	public static MemDAO getInstance() {
		return instance;
	}
	public MemberDTO loginlist(String id, String pwd) {
		
		
		String sql = "SELECT * FROM MEMBER WHERE id = ?, pwd = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		MemberDTO member = new MemberDTO();
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setId(rs.getString("pwd"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return member;
		
	}

}
