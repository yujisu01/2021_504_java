<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
	<div align="center">
	<h3>[글 내용 조회]</h3>
	<table border="1" style="width: 80%;">
		<tr>
			<th>작성자</th>
			<td>${bDto.id}</td>
			
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${bDto.subject}</td>			
		</tr>
		<tr>
			<th>내용</th>
			<%-- <td colspan="3">${dto.b_content }</td> --%> <!-- 줄바꿈 처리를 못하는 문제 발생 -->
			<td colspan="3">
				<%--=dto.getB_content().replace("\r\n", "<br />") --%>	<!-- 자바 코드로 줄바꿈 처리 -->
				${bDto.content}
			</td>
		</tr>
		<input type="button" value="목록보기" onclick="location='boardList.bizpoll'">
		<a href="boardDelete.bizpoll?articleNo=${bDto.articleNo }"><button>삭제</button></a>
	</table>  
</div>
</body>
</html>