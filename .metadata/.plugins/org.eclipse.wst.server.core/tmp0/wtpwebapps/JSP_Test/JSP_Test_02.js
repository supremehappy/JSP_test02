/**
 * 
 */
function check(){
	if(document.sign.name.value==""){
		alert("이름 입력")
		document.sign.name.focus();
		return false;
	}else if(document.sign.jumin.value==""){
		alert("주민 입력")
		document.sign.jumin.focus();
		return false;
	}else if(document.sign.jumin2.value==""){
		alert("주민 입력")
		document.sign.jumin2.focus();
		return false;
	}else if(document.sign.id.value==""){
		alert("아디 입력")
		document.sign.id.focus();
		return false;
	}else if(document.sign.pw.value==""){
		alert("비번 입력")
		document.sign.pw.focus();
		return false;
	}else if(document.sign.pw2.value==document.sign.pw.value){
		alert("비번 같지 않아")
		document.sign.pw.focus();
		return false;
	}else if(document.sign.pw2.value==""){
		alert("비번 입력")
		document.sign.pw2.focus();
		return false;
	}else if(document.sign.mail.value==""){
		alert("멜 입력")
		document.sign.mail.focus();
		return false;
	}else if(document.sign.mail2.value==""){
		alert("멜 입력")
		document.sign.mail2.focus();
		return false;
	}else if(document.sign.mail3.value==""){
		alert("멜 입력")
		document.sign.mail3.focus();
		return false;
	}else if(document.sign.post.value==""){
		alert("우편번호 입력")
		document.sign.post.focus();
		return false;
	}else if(document.sign.addr.value==""){
		alert("주소 입력")
		document.sign.addr.focus();
		return false;
	}else if(document.sign.addr2.value==""){
		alert("나머지주소 입력")
		document.sign.addr2.focus();
		return false;
	}else if(document.sign.phone.value==""){
		alert("폰번 입력")
		document.sign.phone.focus();
		return false;
	}else{
		return false;
	}
}