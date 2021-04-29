<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글쓰기 </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function backToList(obj) {
		obj.action="boardList.bizpoll";
		obj.submit();
	}
	function readURL(input) {
		if(input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload= function(e){
				$("#preview").attr("src",e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</head>
<body>
<%@include file="../header.jsp" %>
	<h1 style="text-align: center;">댓글쓰기</h1>
	<form action="boardReply.bizpoll" name="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="articleNo" value="${replyInfo.articleNo }">
		<input type="hidden" name="ref" value="${replyInfo.ref }">
		<input type="hidden" name="re_step" value="${replyInfo.re_step }">
		<input type="hidden" name="re_level" value="${replyInfo.re_level }">
		<input type="hidden" name="id" value="${sessionScope.loginUser.id }">
		
		<table align="center">
			<tr>
				<td align="left">글쓴이&nbsp;</td>
				<td><input type="text" size="5" value="${sessionScope.loginUser.name }" disabled="disabled"></td>
			</tr>
			<tr>
				<td align="right">글제목&nbsp;</td>
				<td><input type="text" size="67" maxlength="100" name="subject"></td>
			</tr>
			<tr>
				<td align="right">글내용&nbsp;</td>
				<td><textarea name="content" rows="10" cols="65" maxlength="8000"></textarea>></td>
			</tr>
			<tr>
				<td align="right">이미지파일 첨부 : &nbsp;></td>
				<td><input type="file" name="fileName" onchange="readURL(this);"></td>
				<td><img id="preview" alt="attach" src="#" width="200" height="200" ></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td>
					<input type="submit" value="등록">
					<input type="button" value="취소" onclick="backToList(this.form);">
					
				</td>
			</tr>
		</table>
		</form>
<%@include file="../footer.jsp" %>
</body>
</html>