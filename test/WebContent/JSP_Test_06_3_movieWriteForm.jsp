<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div{
		text-align: center;
	}
</style>
</head>
<body>
<form action="JSP_Test_06_3_movieWrite.jsp" method="post">
	<h2>정보 등록</h2>
	<table>
		<tr>
			<td>제목 		</td>
			<td><input type="text" name="title" size="20"></td>
		</tr>
		<tr>
			<td>가격 		</td>
			<td><input type="text" name="price" size="20"></td>
		</tr>
		<tr>
			<td>감독 		</td>
			<td><input type="text" name="director" size="20"></td>
		</tr>
		<tr>
			<td>출연배우 		</td>
			<td><input type="text" name="actor" size="20"></td>
		</tr>
		<tr>
			<td>시놉시스 		</td>
			<td><textarea rows="20" cols="70" name="synopsis"></textarea></td>
		</tr>
		<tr>
			<td>장르 		</td>
			<td>
				<select name="genre">
					<option value="로맨스">로맨스</option>
					<option value="스릴러">스릴러</option>
					<option value="미스터리">미스터리</option>
					<option value="액션">액션</option>
					<option value="코미디">코미디</option>
					<option value="애니메이션">애니메이션</option>
				</select>
			</td>
		</tr>
	</table>
	<div>
		<input type="submit" value="ok">
		<input type="reset" value="cancle">
	</div>
</form>
</body>
</html>
