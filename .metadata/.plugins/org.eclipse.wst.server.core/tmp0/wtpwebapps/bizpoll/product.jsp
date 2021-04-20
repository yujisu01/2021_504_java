<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
		<h2>New Item</h2>

		<img alt="" src="images/product_img/${productDetail.p_img}">
		<h3>${productDetail.p_name}</h3>
		<p>
			<fmt:formatNumber value="${productDetail.p_price2}" type="currency"></fmt:formatNumber>
		</p>
		
</body>

</html>