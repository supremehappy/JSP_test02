/**
 * 
 */

function loginCheck(){
	if(document.frm.userid.value.length==0){
		alert("input id");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("plz, input pw");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.userid.value==""){
		alert("input id");
		document.frm.userid.focus();
		return;
	}
	var url="idCheck.do?userid=" +document.frm.userid.value;
	window.open(url,"_blacnk_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(){
	opener.frm.userid.value=document.frm.userid.value;
	opener.frm.reid.value=document.frm.userid.value;
	self.close();
}

function joinCheck(){
	if(document.frm.userid.value.length==0){
		alert("input name");
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length==0){
		alert("input id");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length<4){
		alert("id is over 4");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("plz, input pw");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value!=document.frm.pwd_check.value){
		alert("pw not equls");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.reid.value.length==0){
		alert("not id check");
		frm.userid.focus();
		return false;
	}
	return true;
}