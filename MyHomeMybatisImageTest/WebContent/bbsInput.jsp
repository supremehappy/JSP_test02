<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form){
	if(form.TITLE.value == ""){
		alert("������ �Է��ϼ���.");
		return false;
	}
	if(form.CONTENT.value == ""){
		alert("�� ������ �Է��ϼ���.");
		return false;
	}
}
</script>
<h3 align="center">�Խ��� �۾���</h3>
<form action="bbs-post" method="post" onSubmit="return validate(this)">
<h4>�� �� �� : <input type="text" name="TITLE"></h4>
<textarea cols="80" rows="5" name="CONTENT"></textarea><br/>
<input type="submit" value="�ۿø���"/>
<input type="reset" value="�� ��"/>
</form>
</body>
</html>









