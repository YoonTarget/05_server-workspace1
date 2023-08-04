<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_PostResponsePage</title>
<style>
	h2 {color:red;}
	#name {color:orange;}
	#age {color:blue;}
	#city {color:yellowgreen;}
	#height {color:purple;}
	#gender {color:pink;}
	ul {list-style:none;}
</style>
</head>
<body>
	
	<%
	
		// 스크립틀릿 (scriptlet) == html 문서 내에 자바 코드를 쓸 수 있는 영역
		// int a = 10;
		
		// request.getAttribute("key") : Object (그에 해당하는 value 값)
		String name = (String)request.getAttribute("name"); // downCasting 강제형변환. Object는 모든 것의 부모
		int age = (int)request.getAttribute("age");
		String city = (String)request.getAttribute("city");
		double height = (double)request.getAttribute("height");
		String gender = (String)request.getAttribute("gender");
		String[] foods = (String[])request.getAttribute("foods");
		
	%>
	<!-- int a = 10; -->
	
	<h2>개인정보 응답화면 - POST</h2>
	
	<span id="name"><%= name %></span>님은
	<span id="age"><%= age %></span>살이며,
	<span id="city"><%= city %></span>에 살고,
	키는 <span id="height"><%= height %></span>cm인
	
	<!-- 성별은 -->
	
	<% if(gender == null) { %>
		선택하지 않았습니다. <br> <!-- case1 -->
	<% } else { %>
	
		<% if(gender.equals("M")) { %>	
		<span id="gender">남자</span>입니다. <br> <!-- case2_1 -->
		<% } else { %>
		<span id="gedner">여자</span>입니다. <br> <!-- case2_2 -->
		<% } %>
		
	<% } %>
		
	좋아하는 음식은
	
	<% if(foods == null) { %>
		없습니다. <br>
	<% } else { %>
		<ul>
			<li><%= String.join(", ", foods) %></li>
			<% for(int i = 0; i < foods.length; i++) { %>
				<li><%= foods[i] %></li>
			<% } %>
		</ul>
		입니다.
	<% } %>
</body>
</html>