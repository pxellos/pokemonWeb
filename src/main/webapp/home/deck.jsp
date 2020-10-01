<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>포켓몬 덱</title>
<style type='text/css'>
#content {
	width: 100%;
	height: 150%;
	float: left;
	background-image: url('../imgs/괴까츄덱.png');
	background-size: 1400px;
}
</style>
</head>
<body>

	<h2 align="center">포켓몬 덱</h2>
	<br />
	<br />
	<c:choose>
		<c:when test="${pokemonEntityList == null || SIZE =='NO'  }">
			<h4 align="center">★신규회원 포켓몬 뽑기★</h4>
			<br />
		</c:when>
		<c:otherwise>
			<h5 align="center">
				<span style="color: blue;">포켓몬의 능력치를 확인하세요. 스킬과 진화도 체크하세요.</span>
			</h5>
			<br />
			<c:forEach var="pokemonEntityList" items="${pokemonEntityList }"
				varStatus="status">
				<form action="">
					<input type="hidden" name="pokemonname"
						value=${pokemonEntityList.pokemonName }>

					<table boder="1" bordercolor="gray" width="330" height="280"
						align="left">
						<tr bgcolor="gray" align="center">
							<td colspan="3" span style="color: white">DECK
								NO.${status.count}</td>
						</tr>
						<tr>
							<td width="70" align="center">도감번호</td>
							<td width="70" align="center">${pokemonEntityList.pokemon_Variety_VarietyNumber}</td>
							<td rowspan="6" align="center"><img alt=""
								src="../imgs/pokemon/${pokemonEntityList.pokemon_Variety_VarietyNumber}.png"
								width="70%"></td>
						</tr>
						<tr>
							<td width="70" align="center">이름</td>
							<td width="70" align="center">${ pokemonEntityList.pokemonName}</td>
						</tr>
						<tr>
							<td width="70" align="center">어버이</td>
							<td width="70" align="center">${ pokemonEntityList.userInfo_Id}</td>
						</tr>
						<tr>
							<td width="70" align="center">타입1</td>
							<td width="70" align="center">${ pokemonEntityList.typeOne}</td>
						</tr>
						<tr>
							<td width="70" align="center">타입2</td>
							<td width="70" align="center">${ pokemonEntityList.typeTwo}</td>
						</tr>
						<td colspan="3" align="center"><a href="#"
							onclick="window.open('','skill_result','width=500,height=350').focus()">☞스킬
								체크</a>&emsp; <a href="#"
							onclick="window.open('','skill_result','width=500,height=350').focus()">☞포켓몬
								진화</a>&emsp; <a
							href="../deck/delete.html?pokemonname=${pokemonEntityList.pokemon_Variety_VarietyNumber }">☞삭제
						</a></td>
					</table>
				</form>
			</c:forEach>
		</c:otherwise>
	</c:choose>

</body>
</html>