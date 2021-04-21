<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script type="text/javascript" src="js/member.js">
</script>

	<article>
		<h2>Join Us></h2>
		<form action="join.bizpoll" id="join" method="post" name="frm">
			<fieldset>
				<legend>Basic Info</legend>
				<label>User ID</label>
				<input type="text" name="id" size="12" maxlength="36">
				<input type="hidden"name="reid">
				<input type="button" value="중복체크" class="dup" onclick="idcheck();"><br>
				<label>Password</label>
				<input type="password" name="pwd"><br>
				<label>Retype Password</label>
				<input type="password" name="pwdCheck"><br>
				<label>Name</label>
				<input type="text" name="name"><br>
				<label>E-Mail</label>
				<input type="text" name="email">
				
			</fieldset>
			<fieldset>
				<legend>Optional</legend>
				<label>Zip Code</label>
				<input type="text" name="zipNum" size="10">
				<input type="button" value="주소찾기" class="dup" onclick="post_zip();"><br>
				<label>Address</label>
				<input type="text" name="addr1" size="50"><br>
				<input type="text" name="addr2" size="50"><br>
				<label>Phone Number</label>
				<input type="text" name="phone">
			</fieldset>
			<div id="buttons">
				<input type="button" value="회원가입" class="submit" onclick="go_save();">
				<input type="reset" value="취소" class="cancel">
			</div>
		</form>
	</article>	
<%@ include file="../footer.jsp" %>