<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function pop(){
	alert('���� �� ������ �����ϱ⿡�� ����ġ�� �����մϴ�!\n�÷��̾���� ������ ���� ����Ʈ�� ȹ���ϼ���.');
}
</script>
</head>
<body>

<br/><h4 align=>������ ������ �����ϼ���.</h4><br/>

<table style="">
	<tr>
		<td width="20%">&nbsp;</td>
		<td>Level 1<br/>
			<a href="../war/warAiPlay.html?level=1"><img alt="" src="../imgs/entry1.jpg" width="50%"></a>
		</td>
		<td>Level 2<br/>
			<a href="#"><img alt="" src="../imgs/entry2.jpg" width="50%" onclick="pop()"></a>
		</td>
		<td width="20%">&nbsp;</td>
	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td><br/>Level 3<br/>
			<a href="#"><img alt="" src="../imgs/entry3.jpg" width="50%" onclick="pop()"></a>
		</td>
		<td><br/>Level 4<br/>
			<a href="#"><img alt="" src="../imgs/entry4.jpg" width="50%" onclick="pop()"></a>
		</td>
		<td width="20%">&nbsp;</td>
	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td><br/>Level 5<br/>
			<a href="#"><img alt="" src="../imgs/entry5.jpg" width="50%" onclick="pop()"></a>
		</td>
		<td><br/>Level 6<br/>
			<a href="#"><img alt="" src="../imgs/entry6.jpg" width="50%" onclick="pop()"></a>
		</td>
		<td width="20%">&nbsp;</td>
	</tr>

</table>

</body>
</html>