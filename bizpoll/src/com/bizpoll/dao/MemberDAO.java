package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;

public class MemberDAO {

	private MemberDAO() {

	}

	private static MemberDAO instance = new MemberDAO();

	// 이해가 안돼요 ..
	public static MemberDAO getInstance() {
		return instance;
	}

	public MemberDTO getMember(String id, String pwd) {
		MemberDTO mDto = null;

		String sql = "SELECT * " + "FROM member " + "WHERE id=? " + "AND pwd=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 오른쪽 이름이 DB에 저장되있는 컬럼명이다.
				mDto = new MemberDTO();
				mDto.setId(rs.getString("id"));
				mDto.setPwd(rs.getString("pwd"));
				mDto.setName(rs.getString("name"));
				mDto.setEmail(rs.getString("email"));
				mDto.setZipNum(rs.getString("zip_num"));
				mDto.setAddress(rs.getString("address"));
				mDto.setPhone(rs.getString("phone"));
				mDto.setUseyn(rs.getString("useyn"));
				mDto.setIndate(rs.getDate("indate"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mDto;

	}

	public int confirmID(String userId) {
		// 회원 가입유무 판별하는 변수
		int result = -1;

		String sql = "SELECT * FROM member WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
				// 얘는 사용가능 (0으로 해도 상관은 없다)
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		// result로 리턴.
		return result;
	}

	public int insertMember(MemberDTO mDto) {
		int result = 0;
		String sql = "INSERT INTO member(id, pwd, name, email, address, phone, zip_num) VALUES(? ,? ,? ,? ,? ,? , ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPwd());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4, mDto.getEmail());
			pstmt.setString(5, mDto.getAddress());
			pstmt.setString(6, mDto.getPhone());
			pstmt.setString(7, mDto.getZipNum());

			result = pstmt.executeUpdate();
			
			//System.out.println(mDto.getZip_num());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	
	}public int deleteMember(MemberDTO mDto) {
		int result = 0;
		
		String sql = "DELETE FROM member WHERE = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
		
	}
}
