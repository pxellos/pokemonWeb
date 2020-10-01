<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>내 포켓몬 정보</title>
<style type="text/css">
 #content{
	width: 100%;
	height: 150%;
	float: left;
 	background-image: url('../imgs/괴까츄.jpg'); 
	background-size: 1400px;
}

.col-md-6{
	color: white;
}

.body{
	color: white;
}

/* .text-center{ */
/* 	text-decoration: underline; */
/* } */
</style>
</head>
<body>
나의 아이디 : ${sessionScope.loginUser }

<style>
.table14_1 table {
	width:500%;
	margin:15px 0;
	border:0;
}
.table14_1 th {
	font-weight:bold;
	background-color:#e7f6fe;
	color:#57c5fe
}
.table14_1,.table14_1 th,.table14_1 td {
	font-size:0.95em;
	text-align:center;
	padding:4px;
	border-collapse:collapse;
}
.table14_1 th,.table14_1 td {
	border: 10px solid #ffffff;
	border-width:1px
}
.table14_1 th {
	border: 1px solid #e7f6fe;
	border-width:1px 0 1px 0
}
.table14_1 td {
	border: 1px solid #eeeeee;
	border-width:1px 0 1px 0
}
.table14_1 tr {
	border: 1px solid #ffffff;
}
.table14_1 tr:nth-child(odd){
	background-color:#f7f7f7;
}
.table14_1 tr:nth-child(even){
	background-color:#ffffff;
}
</style>
<table class=table14_1>
<tr>
<tr>
	<th>회원이름</th><th>보유 포인트</th><th>보유 캐시</th>
</tr>

	<th>${userInfo.userName}</th>
	<th>${playerRank.rating}</th>
	<th>${userInfo.userGold}</th>
</tr>

</table>
<h5 align="center"><span style="color:blue;">당신의 등급입니다.</span></h5><br/>
<table style=" margin:auto; border:0px solid #444444;">
<tr><td align="center">     </td><td align="center">    </td><td align="center">    </td><td align="center">   </td><td align="center">    </td></tr>
<tr>
<c:choose>
	<c:when test="${playerRank.rating >= 4500 }">
		<td><img alt="" src="../imgs/grade/8.png"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 4000 }">
		<td><img alt="" src="../imgs/grade/7.png"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 3500 }">
		<td><img alt="" src="../imgs/grade/6.png"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 3000 }">
		<td><img alt="" src="../imgs/grade/5.png"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 2500 }">
		<td><img alt="" src="../imgs/grade/4.png"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 2000 }">
		<td><img alt="" src="../imgs/grade/3.png"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 1500 }">
		<td><img alt="" src="../imgs/grade/2.png"></td>
	</c:when>
	<c:otherwise>
		<td><img alt="" src="../imgs/grade/1.png"></td>
	</c:otherwise>
</c:choose>
<td> </td>

<td> </td>
<td> </td>
<td><a href="#">${playerRank.userinfo_id }</a></td>

</tr>
</table>
<h5 align="center"><span style="color:blue;"><br/>당신 등급에 맞는 추천 포켓몬입니다.</span></h5><br/>


<table style=" margin:auto; border:0px solid #444444;">
<tr><td align="center">     </td><td align="center">    </td><td align="center">    </td><td align="center">   </td><td align="center">    </td></tr>
<tr>
<c:choose>
	<c:when test="${playerRank.rating >= 4500 }">
		<td><img alt="" src="../imgs/pokemon/150.png" height = "600" width = "600"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 4000 }">
		<td><img alt="" src="../imgs/pokemon/151.png" height = "600" width = "600"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 3500 }">
		<td><img alt="" src="../imgs/pokemon/6.png" height = "600" width = "600"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 3000 }">
		<td><img alt="" src="../imgs/pokemon/2.png" height = "600" width = "600"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 2500 }">
		<td><img alt="" src="../imgs/pokemon/122.png" height = "600" width = "600"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 2000 }">
		<td><img alt="" src="../imgs/pokemon/30.png" height = "600" width = "600"></td>
	</c:when>
	<c:when test="${playerRank.rating >= 1500 }">
		<td><img alt="" src="../imgs/pokemon/15.png" height = "600" width = "600"></td>
	</c:when>
	<c:otherwise>
		<td><img alt="" src="../imgs/pokemon/45.png" height = "600" width = "600"></td>
	</c:otherwise>
</c:choose>
<td> </td>

<td> </td>
<td> </td>
<td><a href="#">${playerRank.userinfo_id }</a></td>

</tr>
</table>


</body>
</html>