/**
 * 
 */
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