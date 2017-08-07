<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form){
	if(form.TITLE.value == ""){
		alert("제목을 입력하세요.");
		return false;
	}
	if(form.CONTENT.value == ""){
		alert("글 내용을 입력하세요.");
		return false;
	}
}
</script>
<h3 align="center">게시판 글쓰기</h3>
<form action="bbs-post" method="post" onSubmit="return validate(this)">
<h4>글 제 목 : <input type="text" name="TITLE"></h4>
<textarea cols="80" rows="5" name="CONTENT"></textarea><br/>
<input type="submit" value="글올리기"/>
<input type="reset" value="취 소"/>
</form>
</body>
</html>









