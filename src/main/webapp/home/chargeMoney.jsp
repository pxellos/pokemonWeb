<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���ϸӴ� ������</title>
<style>
form {
	width: 40%;
	margin: 0 auto;
}

legend {
	display: block;
	padding-left: 10px;
	padding-right: 10px;
	border: 3px solid green;
	background-color: tomato;
	color: white;
}

label {
	display: inline-block;
	float: left;
	clear: left;
	width: 110px;
	margin: 5px;
	text-align: left;
}
</style>
</head>
<body>
	<script type="text/javascript">
		function reload() {
			var url = "../home/reload.jsp"
			window.open(url, 'rand', 'width=350,height=100');
		}

		function validate(form) {

			if (form.id.value == "") {
				alert("���̵� Ȯ�����ּ���.");
				form.id.focus();
				return false;
			} 

			if (form.userGold.value == "���� �ݾ� ����") {
				alert("���� �ݾ��� Ȯ�����ּ���.");
				form.userGold.focus();
				return false;
			}
		}
	</script>
	<h1 align="center">
		<td><img alt="" src="../imgs/jun/dollar.jpg" width="5%"
			align="absmiddle"></td>���ϸӴ� ������
		<td><img alt="" src="../imgs/jun/dollar.jpg" width="5%"
			align="absmiddle"></td>
	</h1>
	<br />

	<table align="center" bordercolor="black" width="550" height="120">
		<tr>
			<td bgcolor="eeeeee" align="center"><a href="#">�޴���</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">�ſ�ī��</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">�ǽð� ������ü</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">īī������</a></td>
		</tr>
		<tr>
			<td bgcolor="eeeeee" align="center"><a href="#">���̹�����</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">��ȭ��ǰ��</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">������ǰ��</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">���ǸӴ�</a></td>
		</tr>
	</table>
	<br />
	<br />

	<form:form name="frm" modelAttribute="userInfo"
		action="../userInfo/getGold.html" method="post"
		onsubmit="return validate(this)">
		<fieldset>
			<legend>���� ������ �Է� ����</legend>
			<br /> ���̵� Ȯ�� &nbsp; &nbsp;&nbsp;&nbsp;
			<form:input path="id" value="" onclick="this.value='${sessionScope.loginUser }';"/>
			<br /> <br /> 
			<label>�̸�</label><input type="text"
				style="width: 100px;"><br /> <br /> <label>�ֹε�Ϲ�ȣ</label><input
				type="text" style="width: 75px;">&emsp;<input type="text"
				style="width: 75px;"><br /> <br /> <label>�޴��� ��ȣ</label> <select
				name="phone" style="width: 60px">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="112">112</option>
				<option value="119">119</option>
				<option value="911">911</option>
			</select>&nbsp; <input type="text" name="phone1" style="width: 50px">&emsp;<input
				type="text" name="phone2" style="width: 50px;"> &emsp;<input
				type="button" value="������ȣ �ޱ�" onClick="reload()" /><br /> <br />
			<label>���� ��ȣ</label><input type="text" style="width: 80px;"><br />
			<br /> <label>�����ݾ�</label>
			<form:select path="userGold">
				<form:option value="���� �ݾ� ����" />
				<form:option value="5000" />
				<form:option value="10000" />
				<form:option value="50000" />
				<form:option value="100000" />
				<form:option value="500000" />
			</form:select>
			<br /> <br />

			<div align="center">
				<input type="submit" value="�����ϱ�" />&emsp;&emsp;<input type="reset"
					value="���" />
			</div>
			<a class="nav-link dropdown-toggle" href="../home/intro.html"> <!--                 <i class="fas fa-bell fa-fw"></i> -->
				<img alt="" src="../imgs/main/homeImage.jpg" width="40" height="40">
			</a>
		</fieldset>
	</form:form>

</body>
</html>