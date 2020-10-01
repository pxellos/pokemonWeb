<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#content{
	width: 100%;
	height:20%;
	float: left;
/*  	background-image: url('../imgs/666.jpg');     */
	background-size: 1700px;
}
</style>
</head>
<body>
<div id="content">
<!-- 	<img alt="" src="../imgs/main1.jpg" width="100%" height="100%"/> -->
<script type="text/javascript">
	alert("또 방문해주세요 ~ 트레이너님 !");
</script>
</div>
<c:choose>
	<c:when test="${sessionScope.loginUser == null }">
	<h3 align="center"><font color="black"> 또 방문해주세요 !</font></h3>
	<div align="center"><a href="../home/intro.html"><font color="red"> to main..</font></a></div>
		<img alt="" src="../imgs/666.jpg" width="100%" height="100%">
	</c:when>
	<c:otherwise>
	<h3 align="center"><font color="black">　　　　<br/>
	로그아웃 되지 않았습니다. 관리자에게 문의해 주세요.</font></h3>
	</c:otherwise>
</c:choose>
</body>
</html>