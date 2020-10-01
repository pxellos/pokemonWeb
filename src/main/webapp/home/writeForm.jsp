<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" 
		uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" 
		uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#writeform { 
	width:1500px; 
	height:1800px;
	background: url('../imgs/main/marketImage.jpg');
	background-repeat: no-repeat;
	background-size: 105%;
	
}
</style>
</head>
<body>
<div id="writeform">
<form:form modelAttribute="writing" action="../write/write.html"
	id="fileupload" method="post" enctype="multipart/form-data">
<form:hidden path="order_no" value="${writing.order_no + 1 }"/>
<c:if test="${ ! empty param.group_id }">
<input type="hidden" name="group_id" value="${param.group_id }"/>
</c:if>	
<c:if test="${ ! empty param.parent_id }">
<input type="hidden" name="parent_id" value="${param.parent_id }"/>
</c:if>

 <section class="page-section" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <br/><h4 class="section-subheading text-muted"><font color="black">포켓몬 마켓에 등록할 글을 작성하세요 !</font></h4><br/>
        </div>
      </div>
      
      <div class="row">
        <div class="col-lg-12">
          <form id="contactForm" name="sentMessage" novalidate="novalidate">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
					<form:input path="title" value="${title}" cssClass="form-control" placeholder="제목을 작성해주세요." required="required" data-validation-required-message="Please enter your title." />
					<p class="help-block text-danger"></p>
				</div>
                <div class="form-group">
					<form:input path="writer_name" value="클릭시 닉네임이  자동입력 됩니다." onclick="this.value='${sessionScope.loginUser }';" cssClass="form-control" placeholder="${sessionScope.loginUser }" required="required" data-validation-required-message="Please enter your name."/>
					<p class="help-block text-danger"></p>
				</div>
               
                <div class="form-group">
					<form:input path="email" cssClass="form-control" placeholder="email" required="required" data-validation-required-message="Please enter your email."/>
					<p class="help-block text-danger"></p>
				</div>
                  
               <div class="form-group">
					<form:password path="password" cssClass="form-control" placeholder="Password..." required="required" data-validation-required-message="Please enter your password."/>
					<p class="help-block text-danger"></p>
				</div>
					
                <div class="form-group">
                 <input class="form-control" id="file" name="image" type="file" placeholder="file" width="200%"">
               	<p class="help-block text-danger"></p>
                </div>
                
              <form:textarea path="content" rows="50" cols="50" style="width:100%; height:400px"></form:textarea>
		
              <div class="clearfix"></div>
              <div class="col-lg-12 text-center" align="center">
              <div class="mt-3" align="center">
					<input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="등록하기" width="50%"/>
					<input type="reset" class="btn btn-block btn-danger btn-lg font-weight-medium auth-form-btn" value="다시 쓰기" width="50%"/>
				</div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</form:form>
</div>
</body>
</html>
