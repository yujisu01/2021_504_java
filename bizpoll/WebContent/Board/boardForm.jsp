<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 등록</title>
<%@ include file="../header.jsp" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader= new FileReader();
			reader.onload = function(e) {
				// 해당되는 파일에대한 정보를 가져온다 (콜백함수 이용)
				$("#preview").attr("src",e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function backToList(obj){
		obj.action="boardList.bizpoll";
		obj.submit();
	}
	
</script>
</head>
<body>
	<h1 style="text-align: center;">글쓰기</h1>
	<form action="boardAdd.bizpoll" name="articleForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${sessionScope.loginUser.id}">
		<table border="0" align="center">
			<tr>
				<td align="right">글제목 : </td>
				<td colspan="4"><input type="text" size="67" maxlength="500" name="subject"></td>
			</tr>
			<tr>
				<td align="right">글내용 : </td>
				<td colspan="4"><textarea name="content" rows="10" cols="65" maxlength="4000"></textarea></td>
			</tr>
			<tr>
				<td align="right">이미지 파일첨부 : </td>
				<td colspan="3">
					<input type="file" name="fileName" onchange="readURL(this);">
				</td>
				<td><img id="preview" alt="preview" src="#" width="70" height="70"></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="4">
					<input type="submit" value="글쓰기">
					<input type="button" value="목록보기" onclick="backToList(this.form);">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>