<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function pop(){ setTimeout(function(){
	alert('������ ���� �Ǿ����ϴ�.');
},2000);
};

function move(){
	
	var id = '${vsId}';
	window.location = "../war/warVsStart.html?vsId="+id;

}

</script>
</head>
<body>
	<script type="text/javascript">
	var array1 = ['a', 'b', 'c'];

	array1.forEach(function(element) {
	  console.log(element);
	});
	</script>
	<br />
	<h5><span style="color:black;">&nbsp;&nbsp;Player ${vsId } (��)���� ������ �����մϴ�. &nbsp;&nbsp; ���ϸ� ������ ���� ���� �� ���� �˴ϴ�.</span></h5>
	<br />
	<table style="margin: auto;">
		<tr>
			<th>${redId } </th> 
			<th class="text-center">${sessionScope.loginUser }</th>
			<th></th>
			<th class="text-center">${vsId } </th>
			<th>${blueId } </th>
		</tr>
		<tr>
			<td><c:forEach items="${redInfo }" var="redInfo">
${redInfo }<br/>
</c:forEach></td>
			<td><img alt="" src="../imgs/pokemon/${redNumber }.png" width="200px"></td>
			<td width="200px" align="center">
<%-- 			<a href="../war/warStart.html?level=${level }"> --%>
			<input type="button" value="���� ����" id="button" name="button" onclick="move(); ">
<!-- 			</a> -->
			</td>
			<td><img alt="" src="../imgs/pokemon/${blueNumber }.png" width="200px"></td>
			<td><c:forEach items="${blueInfo }" var="blueInfo">
${blueInfo }<br/>
</c:forEach></td>
		</tr>
		<tr>
			<td colspan="3">&nbsp; <br /> <br /></td>
		</tr>
		<tr>
		<td></td>
			<td colspan="3"><textarea rows="12" cols="72" id="warLog" readonly="readonly">	
			<c:forEach items="${warLog }" var="log">
${log }
</c:forEach>
				</textarea></td>
		<td></td>
		</tr>
	</table>
	<br />
	<div>
	<h6><span style="color:black;">&nbsp;&nbsp; ������ = {������ ���ݷ�(���� or Ư��) �� (����� ����(���� or Ư��)} �� ��ų ���ݷ�  �� Ÿ�� �� ����   </span></h6>
	<h6><span style="color:black;">&nbsp;&nbsp; �� ��ų ������ ���� �����⿡ ���� ���� ����</span></h6>
	<a><p onclick="window.open('../imgs/Ÿ�Ժ� ��.jpg','','width=400,height=600');">&nbsp;&nbsp;Ÿ�� �� ���� ǥ(Ŭ��)</p></a>
	</div>
</body>
</html>