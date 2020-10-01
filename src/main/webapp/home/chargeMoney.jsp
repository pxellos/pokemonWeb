<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>포켓머니 충전소</title>
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
				alert("아이디를 확인해주세요.");
				form.id.focus();
				return false;
			} 

			if (form.userGold.value == "결제 금액 선택") {
				alert("충전 금액을 확인해주세요.");
				form.userGold.focus();
				return false;
			}
		}
	</script>
	<h1 align="center">
		<td><img alt="" src="../imgs/jun/dollar.jpg" width="5%"
			align="absmiddle"></td>포켓머니 충전소
		<td><img alt="" src="../imgs/jun/dollar.jpg" width="5%"
			align="absmiddle"></td>
	</h1>
	<br />

	<table align="center" bordercolor="black" width="550" height="120">
		<tr>
			<td bgcolor="eeeeee" align="center"><a href="#">휴대폰</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">신용카드</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">실시간 계좌이체</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">카카오페이</a></td>
		</tr>
		<tr>
			<td bgcolor="eeeeee" align="center"><a href="#">네이버페이</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">문화상품권</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">도서상품권</a></td>
			<td bgcolor="eeeeee" align="center"><a href="#">해피머니</a></td>
		</tr>
	</table>
	<br />
	<br />

	<form:form name="frm" modelAttribute="userInfo"
		action="../userInfo/getGold.html" method="post"
		onsubmit="return validate(this)">
		<fieldset>
			<legend>결제 정보를 입력 해줘</legend>
			<br /> 아이디 확인 &nbsp; &nbsp;&nbsp;&nbsp;
			<form:input path="id" value="" onclick="this.value='${sessionScope.loginUser }';"/>
			<br /> <br /> 
			<label>이름</label><input type="text"
				style="width: 100px;"><br /> <br /> <label>주민등록번호</label><input
				type="text" style="width: 75px;">&emsp;<input type="text"
				style="width: 75px;"><br /> <br /> <label>휴대폰 번호</label> <select
				name="phone" style="width: 60px">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="112">112</option>
				<option value="119">119</option>
				<option value="911">911</option>
			</select>&nbsp; <input type="text" name="phone1" style="width: 50px">&emsp;<input
				type="text" name="phone2" style="width: 50px;"> &emsp;<input
				type="button" value="인증번호 받기" onClick="reload()" /><br /> <br />
			<label>인증 번호</label><input type="text" style="width: 80px;"><br />
			<br /> <label>결제금액</label>
			<form:select path="userGold">
				<form:option value="결제 금액 선택" />
				<form:option value="5000" />
				<form:option value="10000" />
				<form:option value="50000" />
				<form:option value="100000" />
				<form:option value="500000" />
			</form:select>
			<br /> <br />

			<div align="center">
				<input type="submit" value="결제하기" />&emsp;&emsp;<input type="reset"
					value="취소" />
			</div>
			<a class="nav-link dropdown-toggle" href="../home/intro.html"> <!--                 <i class="fas fa-bell fa-fw"></i> -->
				<img alt="" src="../imgs/main/homeImage.jpg" width="40" height="40">
			</a>
		</fieldset>
	</form:form>

</body>
</html>