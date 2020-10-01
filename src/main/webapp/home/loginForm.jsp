<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
				prefix="c" %>
<%@ taglib prefix="spring" 
		uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" 
		uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
      input {
        vertical-align: middle;
       	
      }
      
      input.img-button {
        background: url( "../imgs/aa.png" ) no-repeat;
        border: none;
        width: 100px;
        height: 50px;
        cursor: pointer;
        color: white;
      }
      .class{
      	color: white;
      }
      
    </style>
</head>
<body>
<c:choose>
	<c:when test="${param.RESULT == 'nologin' }">
		<h3 align="center">
		서비스를 이용하려면 로그인이 필요합니다.</h3>
		<form action="memberLogin" method="post">
			<label>로그인<span id="join">
			<a href="login.jsp?BODY=join.jsp">회원가입</a></span><br/>
			<input type="text" name="id" size="15"/>
			</label><br/>
			<label>암호<br/>
			<input type="password" name="pwd" size="15"/>
			</label><br/><br/>
			<input type="submit" value="로그인"/>
		</form>
	</c:when>
	<c:when test="${param.RESULT == 'nocart' }">
		<h3 align="center">
		장바구니에 담으려면 로그인이 필요합니다.</h3>
		<form action="cartLogin.do" method="post">
			<label>로그인<span id="join">
			<a href="login.jsp?BODY=join.jsp">회원가입</a></span><br/>
			<input type="text" name="id" size="15"/>
			</label><br/>
			<label>암호<br/>
			<input type="password" name="pwd" size="15"/>
			</label><br/><br/>
			<input type="submit" value="로그인"/>
		</form>
	</c:when>
	<c:otherwise>
		<form:form modelAttribute="userInfo" 
				action="../login/template.html" method="post">
 				
 				<div class="form-group">
				<font color="white">I  D<form:input path="id" class="form-control form-control-lg" placeholder="JSL Legend"/></font>
                </div>
				<font color="red"><form:errors path="id"/></font>

				<div class="form-group">
					<font color="white">PASSWORD<form:password path="password" cssClass="form-control form-control-lg"  /></font>
				</div>
				<font color="red"><form:errors path="password"/></font>
				
				<div class="form-check">
                    <label class="form-check-label text-muted">
                      <input type="checkbox" class="form-check-input">
                     <font color="white"> Keep me signed in</font>
                    </label>
                  </div>

				<div class="mt-3">
					<input type="submit" class="btn btn-block btn-warning btn-lg font-weight-medium auth-form-btn" value="SIGN IN"/>
					<input type="reset" class="btn btn-block btn-danger btn-lg font-weight-medium auth-form-btn" value="CANCEL"/>
				</div>
		</form:form>
<!-- <div align="center"><a href="../home/userentry.html"><font color="white"> 신규 등록 </font></a></div> -->
<div class="text-center mt-4 font-weight-light">
                  <font color="white">Don't have an account?</font> <a href="../home/userentry.html" ><font color="yellow"><u>Create</u></font></a>
                  
</div>
	</c:otherwise>
</c:choose>
</body>
</html>















