<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bizpoll Shop</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="js/member.js"></script>
<!-- <script type="text/javascript" src="js/mypage.js"></script> -->
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="index.bizpoll"><img alt="" src="images/logo.png" width="330" height="300">
				</a>
			</div>
			<nav id="category_menu">
				<ul>
				<c:choose>
					<c:when test="${empty sessionScope.loginUser}">
					<li><a href="login_action.bizpoll">LogIn</a></li>
					<li>|</li>
					<li><a href="contract.bizpoll">Join</a></li>
					
					</c:when>
						<c:otherwise>
						<li style="color: orange">
						${sessionScope.loginUser.name}(${sessionScope.loginUser.name})</li>
						<li><a href="logout.bizpoll">Logout</a></li>
							
							<li><a href="delete.bizpoll">회원탈퇴</a></li>
						
					</c:otherwise>
					</c:choose>
					<li>|</li>
					<li><a>Cart</a></li>
					<li>|</li>
					<li>My Page</li>
					<li>|</li>
					<li><a>Q&amp;A(1:1)</a></li>
					<li>|</li>
					<li><a>App</a></li>
					<li>|</li>
					<li><a href="boardList.bizpoll">Board</a></li>
					<li>|</li>
					
				</ul>
			</nav>
		</header>
	</div>
</body>

</html>