<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ���</title>
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
	<h3 align="center"><font color="black">��������
		[ ${sessionScope.loginUser } ] Ʈ���̳ʴ��� �湮�� ȯ���մϴ� ! </font></h3>
	<img alt="" src="../imgs/loginResult1.jpg" width="100%" height="100%"/>
	<script type="text/javascript">
	alert("�ݰ����ϴ� ~  ${sessionScope.loginUser } Ʈ���̳ʴ� !");
	</script>
	</div>
		
	</c:when>
	<c:otherwise>
	<div id="content2">
		<h3 align="center"><font color="black">
		ID Ȥ�� PASSWORD��  ��ġ���� �ʽ��ϴ�.
		</font></h3>
		<img alt="" src="../imgs/loginResult2.jpg" width="100%" height="50%"/>
		<c:if test="${cartlogin == 'YES' }">
			<a href="../wish/login.html">�� �ٽ� �α��� �ϱ�</a>
		</c:if></div>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${cartlogin == 'SUCCESS' }">
	<a href="#" 
	onClick="self.close();opener.window.location.reload();">�ݱ�</a>
	</c:when>
</c:choose>
</body>
</html>







