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
	confirm("������ �����Ͻðڽ��ϱ�?");
}
</script>
</head>
<body>
<h4 align="center">���ϸ� �о� ���� List</h4>
<c:choose>
	<c:when test="${CART_LIST == null || SIZE == 'NO'}">
	��ٱ��ϰ� ����ֽ��ϴ�. ���ϸ��� ����ּ���.
	</c:when>
	<c:otherwise>
	 <div class="col-lg-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title"><img alt="" src="../imgs/pokemon/cartImage.png" width="110" height="110">&ensp; Pokemon WishList</h4>
                  <p class="card-description">
                   	�о� ������ ���ϸ� ģ�����Դϴ�. �о��� �����Ǹ� [�о�]��ư�� �����ּ���.
                  </p>
	<div class="table-responsive pt-3">
                    <table class="table table-bordered">
                      <thead>
                        <tr class="table-primary">
                          <td align="center" ><font color="gray"><b>���� ��ȣ</font></td>
                          <td align="center" ><font color="gray"><b>���ϸ�</font></td>
                          <td align="center" ><font color="gray"><b>���ϸ� �̸�</font></td>
                          <td align="center" ><font color="gray"><b>���ϸ� �о� ��</font></td>
                          <td align="center" ><font color="gray"><b>���ϸ� �о簡</font></td>
                          <td align="center" ><font color="gray"><b>����</font></td>
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
                          <td align="center"><input type="button" value=����
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
<!-- 			<tr><td width="70">��ǰ</td><td width="250">��ǰ</td> -->
<!-- 			<td width="80">��ǰ</td><td width="80">��ǰ</td><td width="50">��ǰ</td> -->
<!-- 			<td width="100">��ǰ</td> -->
<!-- <!-- 			<td width="80">��ǰ</td></tr> --> 
			
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
<h4 align="center">&ensp;&ensp;<u>�� �о簡  : <fmt:formatNumber groupingUsed="true">
${totalAmount }</fmt:formatNumber><a href="">&ensp;&ensp;
<img alt="" src="../imgs/main/coinImage3.jpg" width="50" height="50" align="top"></a>
<br/></u></h4>

<input type="hidden" name="TOTAL" value=""/>
<!-- <input type="submit" value="�����ϱ�"/> -->

</form>
<br/><br/><br/><br/><br/>
</body>
</html>