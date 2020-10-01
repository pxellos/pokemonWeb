<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
	prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" 
	prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����� ��� ȭ��</title>
<style type="text/css">
 #content{
	width: 100%;
	height: 95%;
	float: left;
 	background-image: url('../imgs/userentry.jpg');  
	background-size: 1400px;
}

.col-md-6{
	color: white;
}

.body{
	color: white;
}

/* .text-center{ */
/* 	text-decoration: underline; */
/* } */
</style>
</head>
<body>
<script type="text/javascript">
function idCheck(){
	if(document.frm.id.value == ""){
		alert("ID�� Ȯ�����ּ���.");
		document.frm.id.focus();
		return;
	}
	var url="../idcheck/idcheck.html?ID="+document.frm.id.value;
	window.open(url,"_blank","width=450,height=200");
}
function validate(form){
	if(form.userName.value == ""){
		alert("�̸��� Ȯ�����ּ���."); form.userName.focus(); return false;
	}
	if(form.id.value == ""){
		alert("ID�� Ȯ�����ּ���."); form.id.focus(); return false;
	}
	if(form.password.value == ""){
		alert("��ȣ�� Ȯ�����ּ���."); form.password.focus(); return false;
	}
	if(form.password.value != form.CONFIRM.value){
		alert("��ȣ�� ��ġ���� �ʽ��ϴ�.");
		form.password.focus(); return false;
	}
// 	if( !form.gender[0].checked && !form.gender[1].checked){
// 		alert("������ �����ϼ���."); form.gender[0].focus(); return false;
// 	}
	if(form.email.value == ""){
		alert("�̸����� Ȯ�����ּ���.");	form.email.focus(); return false;
	}
	if(form.phoneNumber.value == ""){
		alert("��ȭ��ȣ�� Ȯ�����ּ���.");	form.phoneNumber.focus(); return false;
	}
	if(form.address.value == ""){
		alery("�ּҸ� Ȯ�����ּ���.");	form.address.focus();	return false;
	}
	if(form.job.selectedIndex < 1){
		alert("������ Ȯ�����ּ���."); form.job.focus(); return false;
	}
	if(form.idChecked.value == ""){
		alert("ID �ߺ� �˻縦 ���ּ���."); return false;
	}
	if(confirm("�Է��� ������ Ȯ���ϼ̳���?")){
		
	}else { return false; }
}
</script>
	<div align="center" class="body">
	<div id="content">
	<!-- 		<img alt="" src="../imgs/main1.jpg" width="100%" height="90%" /> -->
	</div><br/>
	<div class="brand-logo">
                <img src="../imgs/main/userentry2.png" alt="logo" height="10%" width="10%">
              </div>
		<h2>���ϸ� Ʈ���̳� ���</h2>
		<h2>Pokemon Trainer Entry</h2>
		<br/>
<%-- 		<form:form name="frm" modelAttribute="user" method="post" --%>
<%--  			action="../entry/entry.html" onSubmit="return validate(this)">  --%>
		<form:form name="frm" modelAttribute="userInfo" method="post" action="../entry/entry.html" onsubmit="return validate(this)">
		<input type="hidden" name="idChecked" id="idChecked" />
			<div class="col-md-6">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">Name</label>
					<div class="col-sm-9">
						<form:input path="userName" cssClass="form-control" placeholder="Name..." />
					</div>
				</div>
			</div>
			<br/>

			<div class="col-md-6">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">I D</label>
					<div class="col-sm-9">
						<form:input path="id" cssClass="form-control" placeholder="ID..." />
					</div>
				</div>
			</div>
			<input type="button" value="ID Check" onClick="idCheck()"/>
			<br />
			<br />
			
			<div class="col-md-6">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">PASSWORD</label>
					<div class="col-sm-9">
<!-- 												<input type="password" path="password" placeholder="Password..." class="form-control" />  -->
						<form:password path="password" cssClass="form-control" placeholder="Password..."/>
					</div>
				</div>
			</div>
			<br />
			
			<div class="col-md-6">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">PASSWORD *</label>
					<div class="col-sm-9">
						<input type="password" name="CONFIRM"
							placeholder="Password Confirm..." class="form-control" />
					</div>
				</div>
			</div><br/>
			
			<div class="col-md-6">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">E-mail</label>
					<div class="col-sm-9">
						<form:input path="email" cssClass="form-control" placeholder="Email..." />
					</div>
				</div>
			</div>
			<br/>
			
			<div class="col-md-6">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">PhoneNumber</label>
					<div class="col-sm-9">
						<form:input path="phoneNumber" cssClass="form-control" placeholder="Only digit..."/>
					</div>
				</div>
			</div>
			<br/>
			
			<div class="col-md-6">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">Address</label>
					<div class="col-sm-9">
						<form:input path="address" cssClass="form-control" placeholder="Address..."/>
					</div>
				</div>
			</div>
			<br/><br/>
			
			<div class="col-md-6">
			Job : <form:select path="job" cssClass="form-control" size="4">
<form:option value="--�����ϼ���--"/><form:option value="����л�"/>
<form:option value="���л�"/><form:option value="���п���"/>
<form:option value="ȸ���"/><form:option value="���� Ʈ���̳�"/>
<form:option value="���ϸ� ����"/><form:option value="���ϼ��� ����"/>
</form:select>
</div>
<br/>

			<div class="mb-4">
				<div class="form-check">
					<label class="form-check-label text-muted"> <input
						type="checkbox" class="form-check-input"> 
						<font color="white">I agree to all Terms & Conditions</font>
					</label>
				</div>
			</div>

			<input type="submit" class="btn btn-primary mr-2" value="Submit"/>
			<input type="reset" class="btn btn-light" value="Cancel"/>

			<div class="text-center mt-4 font-weight-light">
				Already have an account? <a href="../home/intro.html" class="text-primary"><font color="white" ><u>Login</u></font></a>
			</div>

<!-- 			<input type="submit" value="���" /> -->
<!-- 			<input type="reset" value="����" /> -->
</form:form>
</div>
	
</body>
</html>










