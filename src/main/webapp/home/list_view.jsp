<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

<c:if test="${empty LIST }">
등록된 게시글이 없습니다.
</c:if>
<c:if test="${ ! empty LIST }">
<table width="100%">
<tr><td align="right"><b>${startRow }~${endRow }/${count }</b></td></tr>
</table>
<!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">거래게시판</h1>
          <p class="mb-4">포켓몬 거래게시판입니다. 포켓몬에 대한 자세한 정보는 여기를 클릭하세요 <a target="_blank" href="https://pokemonkorea.co.kr/pokedex">누르면 웹 포켓몬 도감으로 이동합니다.</a>.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">게시글 목록</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                      <tr>
                      <th>Photo</th>
                      <th>제목</th>
                      <th>닉네임</th>
                      <th>올린날짜</th>
                      <th>가격</th>
      
                    </tr>
                  <c:forEach var="w" items="${LIST }">
                
                   
	<tr><td><img alt="" 
src="${pageContext.request.contextPath }/upload/${w.image_name}"
		width="50" height="50"/></td>
		<td><a href="javascript:goView(${w.writing_id })">
		${w.title }</a></td>
		<td>${w.writer_name }</td>
		<td>${w.register_date }</td>
		<td>${w.email }</td>
	</c:forEach>
                  </thead>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>

</c:if>
<c:set var="startPage" value=
"${currentPage-(currentPage % 10 == 0 ? 10:(currentPage%10))+1}"/>
<c:set var="endPage" value="${startPage + 9 }"/>
<c:if test="${endPage > pageCount }">
	<c:set var="endPage" value="${pageCount }"/>
</c:if>
<c:if test="${startPage > 10 }">
	<a href="javascript:goPage(${startPage - 1 })">[이전]</a>
</c:if>
<c:forEach var="pageNo" begin="${startPage }" end="${endPage }">
	<c:if test="${currentPage == pageNo }"><font size="5"></c:if>
	<a href="javascript:goPage(${pageNo })">${pageNo }</a>
	<c:if test="${currentPage == pageNo }"></font></c:if>
</c:forEach>
<c:if test="${endPage < pageCount }">
	<a href="javascript:goPage(${endPage + 1 })">[다음]</a>
</c:if>
<form name="move" method="post">
	<input type="hidden" name="id"/>
	<input type="hidden" name="PAGE_NUM" value="${currentPage }"/>
</form>
<script type="text/javascript">
function goView(id){
	document.move.id.value = id;
	document.move.action="../read/readImage.html";
	document.move.submit();
}
function goPage(page){
	document.move.action = "../write/writeList.html";
	document.move.PAGE_NUM.value = page;
	document.move.submit();
}
</script>
</body>
</html>










