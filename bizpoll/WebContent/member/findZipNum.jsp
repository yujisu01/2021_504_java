<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<style type="text/css">
	body{
		background-color: #fff;
		font-family: Verdana;
	}
	#popup{
		padding: 0 10px;
	}
	#popup h1{
		font-family: Arial, Helvetica, sans-serif;
		font-size: 45px;
		color: #808080;
		font-weight: normal;
	}
	table#zipcode{
		border-collapse: collapse;
		border-top: 3px solid #fff;
		border-bottom: 3px solid #fff;
		width: 100%;
		margin-top: 15px;
	}
	table#zipcode th, table#zipcode td{
		text-align: center;
		border-bottom: 1px dotted #fff;
		color: #808080;
	}
	table th, td{
		padding: 10px;
	}
	table#zipcode a{
		display: block;
		height: 20px;
		text-decoration: none;
		color: #808080;
		padding: 10px;
	}
	table#zipcode a:hover{
		color: #F90;
		font-weight: bold;
	}
</style>
<script type="text/javascript">
	function result(zipNum, sido, gugun, dong, bunji){
		opener.document.frm.zipNum.value = zipNum;
		opener.document.frm.addr1.value = sido+ " " +gugun+" " +dong+" " +bunji;
		self.close();
		
	}
</script>
</head>
<body>
	<div id="popup">
		<h1>우편번호 검색</h1>
		<form action="find_zip_num.bizpoll" name="frm" method="post">
			동이름 : <input type="text" name="dong">
			<input type="submit" value="찾기" class="submit">		
			</form>
			<table id="zipcode">
				<tr>
					<th>우편번호</th>
					<th>주소</th>
				</tr>
				<c:forEach items="${addressList}" var="addressDTO">
					<tr>
						<td>
							${addressDTO.zipNum}
						</td>
						<td>
							<a href="#addr" onclick="return result('${addressDTO.zipNum}','${addressDTO.sido}','${addressDTO.gugun}','${addressDTO.dong}','${addressDTO.bunji}');">
							${addressDTO.zipNum} ${addressDTO.sido} ${addressDTO.gugun} ${addressDTO.dong} ${addressDTO.bunji}
									
							</a>
						</td>
					</tr>
					</c:forEach>
			</table>
	</div>
</body>
</html>