<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
		uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function con() {
	confirm("정말로 구매하시겠습니까?");
}
</script>
</head>
<body>
<h4 align="center">포켓몬 분양 예정 List</h4>
<c:choose>
	<c:when test="${CART_LIST == null || SIZE == 'NO'}">
	장바구니가 비어있습니다. 포켓몬을 담아주세요.
	</c:when>
	<c:otherwise>
	 <div class="col-lg-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title"><img alt="" src="../imgs/pokemon/cartImage.png" width="110" height="110">&ensp; Pokemon WishList</h4>
                  <p class="card-description">
                   	분양 예정인 포켓몬 친구들입니다. 분양이 결정되면 [분양]버튼을 눌러주세요.
                  </p>
	<div class="table-responsive pt-3">
                    <table class="table table-bordered">
                      <thead>
                        <tr class="table-primary">
                          <td align="center" ><font color="gray"><b>도감 번호</font></td>
                          <td align="center" ><font color="gray"><b>포켓몬</font></td>
                          <td align="center" ><font color="gray"><b>포켓몬 이름</font></td>
                          <td align="center" ><font color="gray"><b>포켓몬 분양 수</font></td>
                          <td align="center" ><font color="gray"><b>포켓몬 분양가</font></td>
                          <td align="center" ><font color="gray"><b>구매</font></td>
                        </tr>
                      </thead>
             <tbody>
        <c:forEach var="cart" items="${CART_LIST }">
			<form action="../wish/modify.html" method="post">
			<input type="hidden" name="CODE" value="${cart.code }"/>
                      <tr class="table-warning">
                          <td align="center">${cart.code }</td>
                          <td align="center"><img alt="" src="${cart.imageRoot }" width="110" height="110"></td>
                          <td align="center"><font color="gray">${cart.pokemonName }</font></td>
                          <td align="center"><input type="text" size="1" name="NUMBER" value="${cart.num }"/></td>

                          <td align="center">${cart.price  * cart.num}</td>
                          <td align="center"><input type="button" value=구입
                              onclick="con(); window.open('../purchase/purchaseSuccess.html?number=${cart.code }','','width=400,height=300');"></td>
                      </tr> 
            </form>
             </c:forEach> 
             </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>

<!-- 	<table border="1"> -->
<!-- 			<tr><td width="70">상품</td><td width="250">상품</td> -->
<!-- 			<td width="80">상품</td><td width="80">상품</td><td width="50">상품</td> -->
<!-- 			<td width="100">상품</td> -->
<!-- <!-- 			<td width="80">상품</td></tr> --> 
			
<%-- 			<c:forEach var="cart" items="${CART_LIST }"> --%>
<!-- 			<form action="../wish/modify.html" method="post"> -->
<%-- 			<input type="hidden" name="CODE" value="${cart.code }"/> --%>
<%-- 			<tr><td >${cart.code }</td> --%>
<%-- 			<td><font color="white">${cart.pokemonName }</font></td> --%>
<%-- 			<td><img alt="" src="${cart.imageRoot }" width="110" height="110"> </td> --%>
<%-- 			<td><fmt:formatNumber groupingUsed="true">${cart.price } --%>
<%-- 			</fmt:formatNumber></td> --%>
			
<%-- 			<td><input type="text" size="3" name="NUMBER" value="${cart.num }"/></td> --%>
<%-- 			<td><fmt:formatNumber groupingUsed="true"> --%>
<%-- 			${cart.price  * cart.num}</fmt:formatNumber></td> --%>
<!-- 			</tr> -->
<!-- 			</form> -->
<%-- 			</c:forEach> --%>
<!-- 		</table> -->

	</c:otherwise>
</c:choose>

<form action="../checkout/checkout.html" method="post"><br/>
<h4 align="center">&ensp;&ensp;<u>총 분양가  : <fmt:formatNumber groupingUsed="true">
${totalAmount }</fmt:formatNumber><a href="">&ensp;&ensp;
<img alt="" src="../imgs/main/coinImage3.jpg" width="50" height="50" align="top"></a>
<br/></u></h4>

<input type="hidden" name="TOTAL" value=""/>
<!-- <input type="submit" value="결제하기"/> -->

</form>
<br/><br/><br/><br/><br/>
</body>
</html>