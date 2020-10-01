<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="../logout/template.html" method="get">
<b><font color="#DC143C"> [ ${sessionScope.loginUser } ] </b> 트레이너님의<br/>
<!-- #800080 #6A5ACD -->
방문을 환영합니다.</font>

<div class="mt-3">
		<input type="submit" class="btn btn-block btn-danger btn-lg font-weight-medium auth-form-btn" value="LOGOUT"/>
</div>

</form>
</body>
</html>










