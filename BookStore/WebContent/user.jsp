<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<script type="text/javascript">
function validate(ID){
	if(form.ID.value == ""){
		alert("ID를 입력하세요.");
		return false;
	}else if(form.PWD.value == ""){
		alert("비밀번호를 입력하세요.");
		return false;
	}else if(form.NAME.value == ""){
		alert("이름을 입력하세요.");
		return false;
	}else if(form.ADDRESS.value == ""){
		alert("주소를 입력하세요.");
		return false;
	}else if(form.Tel.value == ""){
		alert("전화번호를 입력하세요.");
		return false;
	}else if(form.EMAIL.value == ""){
		alert("E-Mail을 입력하세요.");
		return false;
	}else if(form.AGE.value == ""){
		alert("나이를 입력하세요.");
		return false;
	}
	
}
</script>
<h3 align="center">회원 가입</h3>
<form action="user" method="post">
I      D : <input type="text" name="ID" size="12"/><br/>
Password : <input type="password" name="PWD" size="12"/><br/>
Name     : <input type="text" name="NAME" size="12"/><br/>
Address  : <input type="text" name="ADDRESS" size="12"/><br/>
Tel      : <input type="text" name="Tel" size="12"/><br/>
E-Mail   : <input type="text" name="EMAIL" size="12"/><br/>
Age      : <input type="text" name="AGE" size="12"/><br/><br/>
<input type="submit" value="회원 가입"/>
<input type="reset" value="취 소"/>
</form>
</body>
</html>