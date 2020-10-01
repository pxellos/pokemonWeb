<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<p class="mb-4">�Բ� ���� �� ���ϸ��� ģ������ ã�ƺ�����. ������ ��� ���ϸ��� ��ٱ��Ͽ� ���
			�о���� �� �ֽ��ϴ�.</p>
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Pokemon</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
			<table class="table table-bordered" id="user-table" width="100%" cellspacing="0">
			<tr><td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList100.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="100"><font color="gray"><b></b></font></td> 
			<td align="center" width="110"><font color="gray"><b></b></font></td> 
			<td align="center" width="80"><font color="gray"><b></b></font></td>
			<td align="center" width="80"><font color="gray"><b></b></font></td> 
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList01.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList11.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList02.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList22.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList03.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList33.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList04.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList44.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList05.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList55.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList06.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList66.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList08.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList88.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td align="center" width="120"><font color="gray"><b>
			<a href="../pokemon/pokemonList07.html"><img alt="" src="../imgs/main/upIcon.jpg" width="25" height="21"></a>
			<a href="../pokemon/pokemonList77.html"><img alt="" src="../imgs/main/downIcon.jpg" width="25" height="21"></a>
			</b></font></td>
			<td></td> </tr>
		<tr><td align="center" width="100"><font color="gray"><b>������ȣ</b></font></td> <td align="center"><font color="gray"><b>�̹���</b></font></td>
			<td align="center" width="110"><font color="gray"><b>�̸�</b></font></td> <td align="center" width="80"><font color="gray"><b>Type 1</b></font></td>
			<td align="center" width="80"><font color="gray"><b>Type 2</b></font></td> <td align="center" width="120"><font color="gray"><b>�������ݷ�</b></font></td>
			<td align="center" width="120"><font color="gray"><b>��������</b></font></td> <td align="center" width="120"><font color="gray"><b>Ư�����ݷ�</b></font></td>
			<td align="center" width="120"><font color="gray"><b>Ư������</b></font></td> <td align="center" width="80"><font color="gray"><b>���ǵ�</b></font></td>
			<td align="center" width="80"><font color="gray"><b>ü��</b></font></td> <td align="center" width="80"><font color="red"><b>����</b></font></td>
			<td align="center" width="80"><font color="gray"><b>����</b></font></td>
			<td></td> </tr>
			<tbody>	
		<c:forEach items="${pokemonList05}" var="poke">
				<tr>
					<td align="center">${poke.varietyNumber }</td>
					<td align="center"><img alt="" src="${poke.imageRoot }" width="100" height="100"></td>
					<td align="center">${poke.pokemonName }</td>
<%-- 					<a href="../read/readDetail2.html?SEQNO=${poke.varietyNumber}"></a> ���� ��ũ--%>
					<td align="center">${poke.typeOne }</td>
					<td align="center">${poke.typeTwo }</td>
					<td align="center">${poke.varietyPhysicalAttack }</td>
					<td align="center">${poke.varietyPhysicalDefense }</td>
					<td align="center">${poke.varietyTypeAttack }</td>
					<td align="center">${poke.varietyTypeDefense }</td>
					<td align="center">${poke.varietySpeed }</td>
					<td align="center">${poke.varietyHealth }</td>
					<td align="center"><font color="red">${poke.varietyTotal }</font></td>
					<td align="center">${poke.price }</td>
					<td align="center"><a href="#"
					onclick="window.open('../wish/addCart.html?CODE=${poke.varietyNumber}','cart_result','width=400,height=300').focus()"><img alt="" src="../imgs/main/cartImage2.jpg" width="40" height="40"></a></td>
				</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			</div>
		</div>
	</div>
	<br/><br/>
<c:forEach var="page" begin="1" end="${COUNT }">
	<a href="../pokemon/pokemonList05.html?pageNo=${page }">${page }</a>
</c:forEach>
</body>
</html>