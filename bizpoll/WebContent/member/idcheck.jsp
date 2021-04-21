<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복체크</title>
<style type="text/css">
	body{
		background-color: #fff;
		font-family: Verdana;
	}
	#wrap{
		margin: 0 20px;
	}
	h1{
		font-family: Arial, Helvetica, sans-sefif;
		font-size: 45px;
		color: #808080;
		font-weight: normal;
	}
	div{
		font-family: Arial, Helvetica, sans-serif;
		color: #808080;
		font-weight: normal;
	}
	input[type=button], input[type=submit]{
		float: right;
	}
</style>
<script type="text/javascript">
	function idok() {
		// opener:부모객체의 폼네임의 인풋네임의 value값을 넣어줘라
		// jsp에서 EL표기법쓰기
		opener.frm.id.value="${id}";
		opener.frm.reid.value="${id}";
		self.close();
	}
</script>
</head>
<body>
	<div id="wrap">
		<h1>중복 확인</h1>
		<form action="id_check_form.bizpoll" name="frm" method="post" style="margin-right: 0">
		 User ID<input type="text" name="id" value="">
		 		<input type="submit" value="검색" class="submit"><br>
		 <div style="margin-top:20px;">
		 	<c:if test="${message == 1}">
		 		<script type="text/javascript">
		 			opener.document.frm.id.value="";
		 		</script>
		 		${id }는 이미 사용중인 아이디 입니다
		 	</c:if>
		 	<c:if test="${message == -1}">
		 		${id }는 사용가능한 아이디입니다.
		 		<input type="button" value="사용" class="cancel" onclick="idok();">		 	
		 		</c:if>
		 </div>
		</form>
	</div>
	
</body>
</html>