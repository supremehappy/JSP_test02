<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label {
	width:160px;
	display: inline-block;
	float: left;
}
</style>
<script type="text/javascript" src="JSP_Test_02.js"></script>
</head>
<body>
	<form action="JSP_test_02" method="get" name="sign">
		<label>이름 : </label>
		<input type="text" name="name"><br>
		<label>주민 : </label>
		<input type="text" name="jumin">-<input type="password" name="jumin2"><br>
		<label>아디 : </label>
		<input type="text" name="id"><br>
		<label>비번 : </label>
		<input type="password" name="pw"><br>
		<label>비번확인 : </label>
		<input type="password" name="pw2"><br>
		<label>이메일 : </label>
		<input type="text" name="mail">@<input type="text" name="mail2">
		<select name="mail3" size="1">
			<option value="">선택</option>
			<option value="naver.com">naver.com</option>
			<option value="daum.net">daum.net</option>
			<option value="google.com">google.com</option>
		</select>
		<br>
		<label>우편번호: </label>
		<input type="text" name="post"><br>
		<label>주소 : </label>
		<input type="text" name="addr">&nbsp;<input type="text" name="addr2"><br>
		<label>폰번 : </label>
		<input type="text" name="phone"><br>
		<label>직업 : </label>
		<select name="job" size="3">
			<option value="">선택</option>
			<option value="학생">학생</option>
			<option value="군인">군인</option>
			<option value="언론">언론</option>
			<option value="공무원">공무원</option>
			<option value="유통업">유통업</option>
			<option value="제조업">제조업</option>
			<option value="운수업">운수업</option>
			<option value="개발자">개발자</option>
			<option value="자영업">자영업</option>
		</select><br>
		<label>메일수신 : </label>
		<input type="radio" name="chk_mail" value="ok">수신
		<input type="radio" name="chk_mail" value="no">거부
		<br>
		<label>관심분야 : </label>
		<input type="checkbox" name="item" value="신발">신발
		<input type="checkbox" name="item" value="원두">원두
		<input type="checkbox" name="item" value="창업">창업
		<input type="checkbox" name="item" value="헤어">헤어
		<br><hr>
		<input type="submit" value="send" onclick="return check()">&nbsp;
		<input type="reset" value="cancle">
	</form>
</body>
</html>