package com.bizpoll.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.bizpoll.common.FileUpLoad;
import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardReplyAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = new BoardDAO();
		
		Map<String, String> boardMap = FileUpLoad.upload(request, response);
		
		// boardMap에 담겨오는 ref 를 형변환시켜서 parentNo에 담기 (맞나?)
		int parentNo = Integer.parseInt(boardMap.get("ref"));
		// 댓글은 첨부파일 들어간게 없으니 번호를 재생성해서 가져옴 
		int articleNo = bDao.getNewArticleNo();
		String subject = boardMap.get("subject");
		String content = boardMap.get("content");
		String fileName = boardMap.get("fileName");
		String savePath = boardMap.get("savePath");
		String id = boardMap.get("id");
		
		int ref = parentNo;
		int re_step = Integer.parseInt(boardMap.get("re_step"));
		int re_level = Integer.parseInt(boardMap.get("re_level"));
		
		bDto.setSubject(subject);
		bDto.setContent(content);
		bDto.setFileName(fileName);
		bDto.setRef(ref);
		bDto.setRe_step(re_step);
		bDto.setRe_level(re_level);
		bDto.setId(id);
		
		int result=0;
		
		result= bDao.replyReStepUdate(bDto);
		result= bDao.create(bDto);
		
		if (fileName != null && fileName.length() != 0) {
			File srcFile = new File(savePath + "\\" + "temp" + "\\" + fileName);
			File destDir = new File(savePath + "\\" + articleNo);
			
			destDir.mkdirs();
			
			FileUtils.moveFileToDirectory(srcFile, destDir, true);
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		if(result > 0) {
			pw.print("<script>" + "alert('댓글을 추가했습니다.');" + "location.href='" + "boardList.bizpoll';" + "</script>");
		}else {
			pw.print("<script>" + "alert('댓글 작성 실패');" + "location.href='" + "login_action.bizpoll';" + "</script>");
		}
		return null;
	}

}
