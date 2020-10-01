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
<p align="center">당신의 인증번호는</p><div align="center" id="temp"></div><br/>
<div align="center"><input type="button" value="다시받기" onClick="reMake()"/>&nbsp;
<input type="button" value="닫기" onClick="window.close()"/>
<a href="#" onClick="window.close();history.back()">이전</a></div>
</body>

</html>