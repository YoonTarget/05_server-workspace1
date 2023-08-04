<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_directiveInclude</title>
</head>
<body>
	<h1>include 지시어</h1>
	
	<div style="border:1px solid black">
		<%@ include file="01_scriptingElement.jsp"%>
	</div>
	
	포함한 jsp 상에 선언되어 있는 변수를 가져다 사용할 수 있다. (css도 포함되어 있다면 사용 가능) <br><br>
	
	1부터 100까지의 총합계 : <%= sum %> <br>
	
</body>
</html>