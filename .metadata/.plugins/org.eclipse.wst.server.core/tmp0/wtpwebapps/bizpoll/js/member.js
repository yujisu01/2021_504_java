/**
 * 
 */
function idcheck(){
	if(document.frm.id.value == ""){
		alert("아이디를 입력해주세요");
		document.frm.id.focus();
		// 리턴안해주면 동작안멈춤
		return;
	}
	// 입력된 아이디를 가지러 간다 (변수에 담아서)
	var url = "id_check_form.bizpoll?id=" + document.frm.id.value;
	// 자식창 띄우기
	var w = 400;
	var h = 299;
	
	var LeftPosition = (screen.width-w)/2;
	var TopPosition = (screen.height-h)/2;
	
	// blank1은 새끼창의 이름
		window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, " +
			"width=" + w + ", height=" + h + ", top=" + TopPosition + ", left=" + LeftPosition);
	
	
}

function post_zip(){
	var url = "find_zip_num.bizpoll";
		window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, " +
				"width=500, height=300,top=300, left=300");
}
function go_next() {
	// 동의함이 체크가 됐다면
	if (document.frm.okno1[0].checked == true) {
		// 입력할수있는 폼화면이 떠야한다
		// contract.jsp파일의 form action주소랑 같아야함.
		document.frm.action = "join_form.bizpoll";
		// 가야할 장소(쏴주는곳)
		document.frm.submit();
		// 동의안함이 체크가 됐다면
	} else if (document.frm.okno1[1].checked == true) {
		alert("약관에 동의해야 가입이 됩니다.");
	}
}

function go_save(){
	if (document.frm.id.value == "") {
		alert("아이디를 입력해 주세요");
		document.frm.id.focus();
	}else if (document.frm.reid.value == "-1") {
		document.frm.reid.focus();
	}else if (document.frm.pwd.value == ""){
		alert("비밀번호를 입력해주세요");
		document.frm.pwd.focus();
	}else if (document.frm.pwd.value != document.frm.pwdCheck.value){
		alert("비밀번호가 일치하지 않습니다.")
		document.frm.pwd.focus();
	}else if (document.frm.name.value == ""){
		alert("이름을 입력해주세요");
		document.frm.name.focus();
	}else if (document.frm.email.value == ""){
		alert("이메일을 입력해주세요");
		document.frm.email.focus();
	}else{
		document.frm.action="join.bizpoll";
		document.frm.submit();
	}
}
function mem_delete(){
	alert("회원 탈퇴하시겠습니까?");
	
}