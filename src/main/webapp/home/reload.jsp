<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function reMake(){
	location.reload();
}

function makeRand(from,to){
	return parseInt(Math.random()*(to-from+1))+from;
}
function showRand(){
	var str="";
	for(var i=0; i<5; i++){
		str=str + makeRand(0,9);
	}
	document.getElementById("temp").innerHTML=str;
}


</script>
</head>
<body onload="showRand()">
<p align="center">����� ������ȣ��</p><div align="center" id="temp"></div><br/>
<div align="center"><input type="button" value="�ٽùޱ�" onClick="reMake()"/>&nbsp;
<input type="button" value="�ݱ�" onClick="window.close()"/>
<a href="#" onClick="window.close();history.back()">����</a></div>
</body>

</html>