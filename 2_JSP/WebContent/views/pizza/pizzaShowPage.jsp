<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String userName = (String)request.getAttribute("userName");
	String phone = (String)request.getAttribute("phone");
	String address = (String)request.getAttribute("address");
	String message = (String)request.getAttribute("message");
	String pizza = (String)request.getAttribute("pizza");
	String[] topping = (String[])request.getAttribute("topping");
	String[] side = (String[])request.getAttribute("side");
	String payment = (String)request.getAttribute("payment");
	int price = (int)request.getAttribute("price");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_pizzaShowPage</title>
</head>
<body>

	
	<h1>피자 결제 페이지</h1>

	<h2>주문내역</h2>

	<h4>[ 주문자 정보 ]</h4>
	
	<ul>
		<li id="userName">성함 : <%= userName %></li>
		<li id="phone">전화번호 : <%= phone %></li>
		<li id="address">주소 : <%= address %></li>

		<% if(message.equals("")) { %>
		<!-- case1. 요청사항 작성 안 한 경우 -->
		<li>요청사항 : 작성안함</li>
		<% } else { %>
		<!-- case2. 요청사항 작성 한 경우 -->
		<li id="message">요청사항 : <%= message %></li>
		<% } %>
	</ul>

	<br>

	<h4>[ 주문 정보 ]</h4>
	<ul>
		<li id="pizza">메뉴 : <%= pizza %></li>
		
		<% if(topping == null) { %>
		<li>토핑 : 선택안함</li> <!-- case1 -->
		<% } else { %>
		<li id="topping">토핑 : <%= String.join("/", topping) %></li> <!-- case2 -->
		<% } %>

		<% if(side == null) { %>
		<li>사이드 메뉴 : 선택안함</li> <!-- case1 -->
		<% } else { %>
		<li id="side">사이드 메뉴 : <%= String.join("/", side) %></li> <!-- case2 -->
		<% } %>

		<li id="payment">결제방식 : 
		<% if(payment.equals("card")) { %>
			카드
		<% } else { %>
			현금
		<% } %>
		</li>
	</ul>

	<hr>

	<h3>위와 같이 주문하셨습니다.</h3>
	<h2>총 가격 : <%= price %>원</h2>

</body>
</html>