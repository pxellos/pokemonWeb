<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 결과</title>
<style type="text/css">
#content{
	width: 99%;
	height:30%;
	float: left;
/*  	background-image: url('../imgs/loginResult1.jpg');     */
	background-size: 1800px;
}
#content2{
	width: 100%;
	height:100%;
	float: right;
/*  	background-image: url('../imgs/loginResult2.jpg');     */
	background-size: 1300px;
}
</style>
</head>
<body>

<c:choose>
	<c:when test="${sessionScope.loginUser != null }">
		<div id="content">
	<h3 align="center"><font color="black">　　　　
		[ ${sessionScope.loginUser } ] 트레이너님의 방문을 환영합니다 ! </font></h3>
	<img alt="" src="../imgs/loginResult1.jpg" width="100%" height="100%"/>
	<script type="text/javascript">
	alert("반갑습니다 ~  ${sessionScope.loginUser } 트레이너님 !");
	</script>
	</div>
		
	</c:when>
	<c:otherwise>
	<div id="content2">
		<h3 align="center"><font color="black">
		ID 혹은 PASSWORD가  일치하지 않습니다.
		</font></h3>
		<img alt="" src="../imgs/loginResult2.jpg" width="100%" height="50%"/>
		<c:if test="${cartlogin == 'YES' }">
			<a href="../wish/login.html">■ 다시 로그인 하기</a>
		</c:if></div>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${cartlogin == 'SUCCESS' }">
	<a href="#" 
	onClick="self.close();opener.window.location.reload();">닫기</a>
	</c:when>
</c:choose>
</body>
</html>







