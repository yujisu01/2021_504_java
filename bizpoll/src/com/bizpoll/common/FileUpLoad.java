package com.bizpoll.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpLoad {
	// 파라미터로  request,response 받음
	public static Map<String, String> upload(HttpServletRequest request, HttpServletResponse response){
		// 글,이미지 저장폴더
		String savePath = "C:\\Users\\504\\eclipse-workspace\\bizpoll\\WebContent\\images\\board";
		Map<String, String> boardMap = new HashMap<String, String>();
		String encodeing = "UTF-8";
		// IO클래스로 가져옴
		// 현재디렉토리 path
		File currentDirPath = new File(savePath);
		// commons로 가져옴 (톰캣 아님)
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 이미지를 받아온후 주입시켜준 후 셋팅해줌.
		factory.setRepository(currentDirPath);
		// size를 정해줌
		// 1024 * 1024 = mb (=10mb)
		factory.setSizeThreshold(10 * 1024 * 1024);
		// commons로 가져옴
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// io객체를 사용하므로 유효성검사 해야됨
		// form태그에 여러개를 받았으니까 하나씩 꺼내서 List로 담아서 처리해주겠다
		// commons의 FileItem이 알아서 반환해줌
		try {
			List<FileItem> items = upload.parseRequest(request);
			// 하나씩 꺼내옴 (글제목,글내용...)
			for(int i=0; i< items.size(); i++) {
				// list에서 꺼내옴 (오브젝트 타입이므로, fileItem타입으로 형변환)
				FileItem fileItem = (FileItem)items.get(i);
				
				// formfield값이 존재한다면
				if (fileItem.isFormField()) {
					// input의 name명 찾아옴
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encodeing));
					
					// key= 필드명, value= 해당되는값
					boardMap.put(fileItem.getFieldName(), fileItem.getString(encodeing));
				}else {
					System.out.println("파라미터명 : " + fileItem.getFieldName());
					System.out.println("파일크기: " + fileItem.getSize() + "bytes");
					
					// 데이터가 존재한다면
					if (fileItem.getSize() > 0) {
						// 경로를 잘라냄 (저장소를 만들기 위해서). 윈도
						int idx = fileItem.getName().lastIndexOf("\\");
						
						// 리눅스or유닉스 경로잡을때 처리함
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						// subString으로 잘랐다. 
						// +1 한이유 : 윈도우면 \\로 자르고, 리눅스면 /로 자르기
						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명 : " + fileName);
						
						boardMap.put(fileItem.getFieldName(), fileName);
						
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						// 파일을 씀. 일단 임시파일에 저장됨.
						// 여기까지는 신규나 업데이트나 똑같음
						fileItem.write(uploadFile);
					}
				}
			}
			boardMap.put("savePath", savePath);
		} catch (Exception e) {
			e.printStackTrace();
		}// 신규등록, 수정에서 얘를 호출함. 
		return boardMap;
	}
		
	
}
