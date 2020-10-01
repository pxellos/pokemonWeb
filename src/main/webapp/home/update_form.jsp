<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" 
		uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
		uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form){
	if(form.title.value==""){
		alert("������ �Է��ϼ���."); return false;}
	if(form.writer_name.value==""){
		alert("�ۼ��ڸ� �Է��ϼ���."); return false;}
	if(form.email.value==""){
		alert("�̸����� �Է��ϼ���."); return false;}
	if(form.password.value==""){
		alert("��ȣ�� �Է��ϼ���."); return false;}
	if(form.content.value==""){
		alert("������ �Է��ϼ���."); return false;}
	var result = confirm("������ �����Ͻðڽ��ϱ�?");
	if(result == false) return false;
}
</script>
<form:form modelAttribute="writing" action="../write/updateDo.html"
	method="post" enctype="multipart/form-data"
	onSubmit="return validate(this)">
<form:hidden path="writing_id" value="${writing.writing_id }"/>
<table border="1" width="100%">
<tr><td>������</td><td><form:input path="title" size="20"
	value="${writing.title }"/></td></tr>
<tr><td>�ۼ���</td><td><form:input path="writer_name" size="20"
	value="${writing.writer_name }"/></td></tr>
<tr><td>�̸���</td><td><form:input path="email" size="30"
	value="${writing.email }"/></td></tr>
<tr><td>�� ȣ</td><td><form:password path="password" size="20"/>
	</td></tr>
<tr><td>�̹���</td><td><input type="file" name="image"/><br/>
	<img alt="" width="350" border="0" src=
"${pageContext.request.contextPath }/update/${writing.image_name}">
	</td></tr>
<tr><td>�۳���</td><td><form:textarea path="content" rows="8"
	cols="40" value="${writing.content }"
	style="width:100%; height:300px"></form:textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="�� ��"/>
	<input type="button" value="�� ��" 
			onClick="javascript:history.go(-1)"/>	
</table>
</form:form>
</body>
</html>














