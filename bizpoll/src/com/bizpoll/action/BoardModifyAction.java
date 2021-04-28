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

public class BoardModifyAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String url = "Board/boardList.jsp";
		
		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = new BoardDAO();
		
		Map<String, String> boardMap = FileUpLoad.upload(request, response);
		
		int articleNo = Integer.parseInt(boardMap.get("articleNo"));
		String title = boardMap.get("subject");
		String content = boardMap.get("content");
		String originalFileName = boardMap.get("originalFileName");
		String fileName = boardMap.get("fileName");
		String savePath = boardMap.get("savePath");
		
		bDto.setArticleNo(articleNo);
		bDto.setSubject(title);
		bDto.setContent(content);
		bDto.setFileName(fileName);
		
		// update 해야 하므로. 넣어줌
		int result = bDao.modify(bDto);
		
		if (fileName != null && fileName.length() != 0) {
			File srcFile = new File(savePath + "\\" + "temp" + "\\" + fileName);
			File destDir = new File(savePath + "\\" + (articleNo));		
			destDir.mkdirs();
			FileUtils.moveFileToDirectory(srcFile, destDir, true);
			
			// originalFileName으로 찾아가라
			// 뭔가를 추가하고, 기존에 있는걸 날리는 과정
			File oldFile = new File(savePath + "\\" + articleNo + "\\" + originalFileName);
			oldFile.delete();
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			
			if(result > 0) {
				pw.print("<script>" + "alert('글 수정 완료');" + "location.href='" + "boardList.bizpoll';" + "</script>");
			}else {
				pw.print("<script>" + "alert('등록에 실패했습니다');" + "history.go(-1);" + "</script>");
			}
			
			
		}
		return null;
	}

}
