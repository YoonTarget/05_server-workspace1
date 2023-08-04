<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_pizzaShowPage</title>
</head>
<body>

	<%
	
		String userName = (String)request.getAttribute("userName");
		String phone = (String)request.getAttribute("phone");
		String address = (String)request.getAttribute("address");
		String message = (String)request.getAttribute("message");
		String pizza = (String)request.getAttribute("pizza");
		String[] topping = (String[])request.getAttribute("topping");
		String[] side = (String[])request.getAttribute("side");
		String payment = (String)request.getAttribute("payment");
	
	%>
	
	<h1>피자 주문 정보</h1>
	
	<ul>
		<li id="userName">주문자 : <%= userName %></li>
		<li id="phone">전화번호 : <%= phone %></li>
		<li id="address">주소 : <%= address %></li>
		<li id="message">요청사항 : <%= message %></li>
		<li id="pizza">메뉴 : <%= pizza %></li>
		<li id="topping">토핑 : <%= String.join("/", topping) %></li>
		<li id="side">사이드 메뉴 : <%= String.join("/", side) %></li>
		<li id="payment">결제방식 : 
		<% if(payment.equals("card")) { %>
			카드
		<% } else { %>
			현금
		<% } %>
		</li>
	</ul>

</body>
</html>