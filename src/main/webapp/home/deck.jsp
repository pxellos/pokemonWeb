<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���ϸ� ��</title>
<style type='text/css'>
#content {
	width: 100%;
	height: 150%;
	float: left;
	background-image: url('../imgs/������.png');
	background-size: 1400px;
}
</style>
</head>
<body>

	<h2 align="center">���ϸ� ��</h2>
	<br />
	<br />
	<c:choose>
		<c:when test="${pokemonEntityList == null || SIZE =='NO'  }">
			<h4 align="center">�ڽű�ȸ�� ���ϸ� �̱��</h4>
			<br />
		</c:when>
		<c:otherwise>
			<h5 align="center">
				<span style="color: blue;">���ϸ��� �ɷ�ġ�� Ȯ���ϼ���. ��ų�� ��ȭ�� üũ�ϼ���.</span>
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
							<td width="70" align="center">������ȣ</td>
							<td width="70" align="center">${pokemonEntityList.pokemon_Variety_VarietyNumber}</td>
							<td rowspan="6" align="center"><img alt=""
								src="../imgs/pokemon/${pokemonEntityList.pokemon_Variety_VarietyNumber}.png"
								width="70%"></td>
						</tr>
						<tr>
							<td width="70" align="center">�̸�</td>
							<td width="70" align="center">${ pokemonEntityList.pokemonName}</td>
						</tr>
						<tr>
							<td width="70" align="center">�����</td>
							<td width="70" align="center">${ pokemonEntityList.userInfo_Id}</td>
						</tr>
						<tr>
							<td width="70" align="center">Ÿ��1</td>
							<td width="70" align="center">${ pokemonEntityList.typeOne}</td>
						</tr>
						<tr>
							<td width="70" align="center">Ÿ��2</td>
							<td width="70" align="center">${ pokemonEntityList.typeTwo}</td>
						</tr>
						<td colspan="3" align="center"><a href="#"
							onclick="window.open('','skill_result','width=500,height=350').focus()">�ѽ�ų
								üũ</a>&emsp; <a href="#"
							onclick="window.open('','skill_result','width=500,height=350').focus()">�����ϸ�
								��ȭ</a>&emsp; <a
							href="../deck/delete.html?pokemonname=${pokemonEntityList.pokemon_Variety_VarietyNumber }">�ѻ���
						</a></td>
					</table>
				</form>
			</c:forEach>
		</c:otherwise>
	</c:choose>

</body>
</html>