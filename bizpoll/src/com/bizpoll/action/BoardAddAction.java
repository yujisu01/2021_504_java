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

public class BoardAddAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		// 서블릿에서 자바스크립트를 호출하는 방식.
		// String url을 사용하지 않음
		
		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = new BoardDAO();
		
		// 내가만든 FileUpLoad (common,톰캣 이런거 아님)
		// 매개변수로 request,response받았음 (시작됨)
		Map<String, String> boardMap = FileUpLoad.upload(request, response);
		
		// 최종발급된 Sequecne번호(아티클번호)에 +1을 해줄것이다.
		// 만드는이유:폴더를 만드려고. 
		// 야매 방법이
		int articleNo = bDao.getNewArticleNo();
		String title = boardMap.get("subject");
		String content = boardMap.get("content");
		String fileName = boardMap.get("fileName");
		String savePath = boardMap.get("savePath");
		String id = boardMap.get("id");
		
		bDto.setId(id);
		bDto.setSubject(title);
		bDto.setContent(content);
		bDto.setFileName(fileName);
		bDto.setRef(articleNo + 1);
		// 신규
		bDto.setRe_step(0);
		// 신규는 부모급은 1, 자식 2, 손자 3 
		bDto.setRe_level(1);
		System.out.println("BoardAddAction bDto ===>" + bDto.getFileName());
		
		// 이 result값을 가지고 새 글이 정상으로 됐는지 안됐는지 확인.
		// 0보다 크다면 성공..
		int result = bDao.create(bDto);
		
		// null이 아니고, 0이 아니라면
		if (fileName != null && fileName.length() != 0) {
			// 실제있는 위치를 가서 가져올것이다. 
			// 이렇게 해주면 파일이 생성된다.
			File srcFile = new File(savePath + "\\" + "temp" + "\\" + fileName);
			// 최종발급된 마지막번호 + 1을 하겠다
			File destDir = new File(savePath + "\\" + (articleNo + 1));
			
			destDir.mkdirs();
			//--------여기까지가 디렉토리 생성과정-------
			// 파일잘라내기
			// 경로, 대상, true(즉시 실행해라)
			// temp 없애고, 폴더만들고-> srcFile, destDir 에 붙여넣기 (맞나?)
			FileUtils.moveFileToDirectory(srcFile, destDir, true);
		}
		// html파일이고, 한글깨짐방지
		response.setContentType("text/html; charset=UTF-8");
		// IO객체에서 문자열 처리할때 사용 (2바이트는 문자에 특화)
		PrintWriter pw = response.getWriter();
		
		// result값이 0보다 크다면 (성공했다면)
		if(result > 0) {
			// IO객체를 사용했다. 
			pw.print("<script>" + "alert('새글을 추가했습니다.');" + "location.href='" + "boardList.bizpoll';" + "</script>");
		}else {
			pw.print("<script>" + "alert('등록에 실패했습니다.');" + "history.go(-1);" + "</script>");
		}
		// forward 필요없다
		return null;
	}

}
