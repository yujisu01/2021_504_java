/**
 * 
 */

//document.write("자바스크립트 기동");

function calc() {
		// 첫번째방법.Id를 가지고 취득하는 방법
		/* var x = document.getElementById("x").value;
		var y = document.getElementById("y").value;
		var sum;
		sum = parseInt(x) + parseInt(y);

		// sum이 앞에 있으면 안된다.
		// sum = document.getElementById("sum").value 
		
		// 할당하는 과정
		document.getElementById("sum").value = sum; */
		
		// 두번째방법.Name명을 가지고 취득하는 방법
		var firstNum = parseInt(document.frm.firstNum.value);
		var secondNum = parseInt(document.frm.secondNum.value);
		// "" : 식별자결합
		alert("sum = "+(firstNum+secondNum));
		document.frm.sum.value = firstNum+secondNum;
	}



