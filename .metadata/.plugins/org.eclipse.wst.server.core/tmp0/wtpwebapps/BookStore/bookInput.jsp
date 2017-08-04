<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
	<style>
		#bookInputTable {
			margin: auto;
			border: 0px solid black;
			border-collapse: collapse;
			width: 350px;
		}
		#bookInputTable tr td:nth-child(1) {
			background-color: #c1c1c1;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<script type="text/javascript">
		function validate(form) {// 함수선언 메서드명(매개변수명){}
			if(form.BOOK_TITLE.value == "") {
				alert("도서 제목을 입력하세요.");
				form.BOOK_TITLE.focus();
				return false;
			}
			if(form.WRITER.value == "") {
				alert("저자를 입력하세요.");
				form.WRITER.focus();
				return false;
			}
			if(form.COMPANY.value == "") {
				alert("출판사를 입력하세요.");
				form.COMPANY.focus();
				return false;
			}
			if(form.PRICE.value == "") {
				alert("도서 가격을 입력하세요.");
				form.PRICE.focus();
				return false;
			}
		}
	</script>
	<form action="book-post" method="post" onSubmit="return validate(this)">
		<table id="bookInputTable">
			<tr>
				<th colspan="2" align="center"><h2>도서 등록</h2></th>
			</tr>
			<tr>
				<td>도서 제목</td>
				<td><input type="text" name="BOOK_TITLE" size="30"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="WRITER" size="30"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="COMPANY" size="30"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="PRICE" size="30"></td>
			</tr>
			<tr>
				<th colspan="2" align="center">
					<input type="submit" value="도서 등록"/>
					<input type="reset" value="취 소"/>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>