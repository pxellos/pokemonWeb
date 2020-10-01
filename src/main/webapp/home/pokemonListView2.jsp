<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
 response.setHeader("Cache-Control","no-cache");
 response.setHeader("Pragma","no-cache");
 response.setDateHeader("Expires",0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  <meta http-equiv="Content-type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
</head>
<body>
      <div class="container-fluid">
          <br />
		<h1 class="h3 mb-2 text-gray-800">Pokemon List</h1>
         <p class="mb-4">포켓몬들을 이미지로 찾아보세요 .</p>
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Pokemon</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="80%" cellspacing="0">
                <tbody>	
					<c:forEach items="${pokemonList}" var="poke">
<%-- 				<a href="../read/readDetail2.html?SEQNO=${poke.seqno}"> --%>
				<img alt="" src="${poke.imageRoot }" width="280" height="270">&emsp;&emsp;
									&nbsp;<a href="#"
					onclick="window.open('../wish/addCart.html?CODE=${poke.varietyNumber}','cart_result','width=400,height=300').focus()"><img alt="" src="../imgs/main/cartImage2.jpg" width="40" height="40"></a>
					</c:forEach>
				</tbody>
                </table>
              </div>
            </div>
          </div>
        </div>

<%-- <c:forEach var="page" begin="1" end="${COUNT }"> --%>
<%-- <a href="../read/read.html?pageNo=${page }">${page }</a> --%>
<%-- </c:forEach> --%>
</body>
</html>











