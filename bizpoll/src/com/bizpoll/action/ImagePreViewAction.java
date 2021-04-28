package com.bizpoll.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImagePreViewAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "C:\\Users\\504\\eclipse-workspace\\bizpoll\\WebContent\\images\\board";
		// 파일명 받아오기
		// DB로 안가고 화면에서 전달
		String fileName = request.getParameter("fileName");
		String articleNo = request.getParameter("articleNo");
		// 디버깅용 출력
		System.out.println("fileName ===>" + fileName);
		
		// IO객체
		OutputStream out = response.getOutputStream();
		// 해당되는 경로
		// 화면에서 받은 savePath와 articleNo를 가지고 이동
		String path = savePath + "\\" + articleNo + "\\" + fileName;
		// path를 넣어주면 파일생성 완료
		File imageFile = new File(path);
		
		// no-cache: 브라우저 캐시를 사용하지않겠다
		response.setHeader("Cache-Control", "no-cache");
		// 헤더추가
		response.addHeader("Content-disposition", "attachment);fileName="+fileName);
		
		FileInputStream in = new FileInputStream(imageFile);
		
		// 8kb 버퍼량 : 한번에 8kb씩 가져올거
		byte[] buffer= new byte[8 * 1024];
		
		while(true) {
			// 버퍼에 담은 분량만큼 읽어온다
			int count = in.read(buffer);
			// -1: 다읽어왔으면
			if(count == -1) {
				// 탈출해라
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		// forward 안해줘도 됨.
		return null;
	}
	// 상세봤을때 그 이미지를 클릭했을때 ..

}
