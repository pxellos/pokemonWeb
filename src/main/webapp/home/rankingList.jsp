<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>포켓몬 월드랭킹</title>
</head>
<body>
	<h5 align="center">
		<span style="color: blue;">ID를 클릭하면 대전할 수 있습니다.</span>
	</h5>
	<br />
	<table style="margin: auto; border: 1px solid #444444;">
		<tr>
			<td align="center">Grade</td>
			<td align="center">Rank</td>
			<td align="center">Rating</td>
			<td align="center">ID</td>
			<td align="center">Deck</td>
		</tr>
		<c:forEach var="rank" items="${rankingList }" varStatus="count">
			<tr>
				<c:choose>
					<c:when test="${rank.rating >= 4500 }">
						<td><img alt="" src="../imgs/grade/8.png"></td>
					</c:when>
					<c:when test="${rank.rating >= 4000 }">
						<td><img alt="" src="../imgs/grade/7.png"></td>
					</c:when>
					<c:when test="${rank.rating >= 3500 }">
						<td><img alt="" src="../imgs/grade/6.png"></td>
					</c:when>
					<c:when test="${rank.rating >= 3000 }">
						<td><img alt="" src="../imgs/grade/5.png"></td>
					</c:when>
					<c:when test="${rank.rating >= 2500 }">
						<td><img alt="" src="../imgs/grade/4.png"></td>
					</c:when>
					<c:when test="${rank.rating >= 2000 }">
						<td><img alt="" src="../imgs/grade/3.png"></td>
					</c:when>
					<c:when test="${rank.rating >= 1500 }">
						<td><img alt="" src="../imgs/grade/2.png"></td>
					</c:when>
					<c:otherwise>
						<td><img alt="" src="../imgs/grade/1.png"></td>
					</c:otherwise>
				</c:choose>
				<td>${count.count }</td>
				<td>${rank.rating }</td>
				<td><a href="../war/warPlayerPlay.html?vsId=${rank.userinfo_id }">${rank.userinfo_id }</a></td>
				<td>
					<c:forEach items="${rank.deckList }" var="deck">
						<img alt="" src="../imgs/pokemon/${deck }.png" height="95px"> &nbsp; &nbsp;
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>