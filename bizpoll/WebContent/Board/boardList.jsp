<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
    <%@include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
	.cls1{
		text-decoration: none;
		color: black;
	}
	.cls2{
		text-align: center;
		font-size: 30px;
	}
</style>
<script type="text/javascript">
	function boardWrite(){
	var id = "${sessionScope.loginUser}"
	
	if(id == ""){
		alert("로그인이 필요한 서비스입니다.");
		location.href="login_action.bizpoll";
	}else{
		location.href="boardForm.bizpoll";
	}
}
</script>
</head>
<body>
	<h1 class="cls2">QnA</h1>
	<table align="center" border="1" style="border-collapse: collapse;" width="80%">
		<thead>
			<tr height="10" align="center" bgcolor="lightgray">
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty boardList}">
					<tr height="10">
						<th colspan="5">
							<p align="center">
								<b><span style="font-size: 20px;">등록된 글이 없습니다.</span></b>
							</p>
						</th>
					</tr>
				</c:when>
				<c:when test="${!empty boardList }">
					<c:forEach items="${boardList }" var="boardListDTO" varStatus="status">
						<tr>
							<td width="5%">${status.count}</td>
							<td width="20%">${boardListDTO.id}</td>
							<td width="45%" style="text-align: left;">
								<span style="padding-left: 10px;"></span>
								<c:choose>
									<c:when test="${boardListDTO.re_level > 1 }">
										<c:forEach begin="2" end="${boardListDTO.re_level }" step="1">
											<span style="padding-left: 20px;"></span>
										</c:forEach>
										<span style="font-size: 12px;">[답변]</span>
										<a class="cls1" href="boardDetail.bizpoll?articleNo=${boardListDTO.articleNo}">${boardListDTO.subject }</a>
									</c:when>
								<c:otherwise>
									<a class="cls1" href="boardDetail.bizpoll?articleNo=${boardListDTO.articleNo}">${boardListDTO.subject }></a>
								</c:otherwise>
								</c:choose>
							</td>
							<td width="20%"><fmt:formatDate value="${boardListDTO.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td width="10%">${boardListDTO.readcount }</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
	
	<a class="cls1" href="javascript:boardWrite()">
		<p class="cls2">글쓰기</p>
	</a>
		
<%@include file="../footer.jsp" %>
</body>
</html>