package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaGetServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 1) 전달값 중에 한글이 있을 경우 인코딩 처리 (post 방식일 때만)
		// request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 뽑기 및 데이터 가공처리 (파싱같은 거) => 변수 및 객체 기록
		// request.getParameter("키값") : "벨류값" (String)
		// request.getParameterValues("키값") : ["벨류값", "벨류값", ...] (String[])
		// => 만일 키 값이 존재하지 않을 경우 null 반환
		
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
		// 3) 요청처리 (db에 sql문 실행하러 > Service > Dao)
		
		int price = 0;
		
		switch(pizza) {
		case "콤비네이션피자" : price += 5000; break;
		case "치즈피자" : price += 6000; break;
		case "포테이토피자" : case "고구마피자" : price += 7000; break;
		case "불고기피자" : price += 8000; break;
		}
		
//		int toppingPrice = 0;
		
		if(topping != null) { // 토핑이 null이 아닐 때만 돌리기
			for(int i = 0; i < topping.length; i++) {
				
				/*
				if(topping[i].equals("고구마무스") || topping[i].equals("콘크림무스")) {
					toppingPrice += 1500;
				}
				else if(topping[i].equals("파인애플토핑") || topping[i].equals("치즈토핑")) {
					toppingPrice += 200;
				}
				else {
					toppingPrice += 3000;
				}
				*/
				
				switch(topping[i]) {
				case "고구마무스" : case "콘크림무스" : price += 1500; break;
				case "파인애플토핑" : case "치즈토핑" : price += 2000; break;
				case "치즈바이트" : case "치즈크러스트" : price += 3000; break;
				}
			}
		}
		
		if(side != null) { // 사이드가 null이 아닐 때만 돌리기
			for(int i = 0; i < side.length; i++) {
				switch(side[i]) {
				case "콜라" : case "사이다" : price += 2000; break;
				case "핫소스" : case "갈릭소스" : price += 300; break;
				case "피클" : case "파마산치즈가루" : price += 500; break;
				}
			}
		}
		
		System.out.println("userName : " + userName);
		
		System.out.println("phone : " + phone);
		
		System.out.println("address : " + address);
		
		if(message == "") {
			System.out.println("message : 미입력");
		}
		else {
			System.out.println("message : " + message);
		}
		
		System.out.println("pizza : " + pizza);
		
		if(topping == null) {
			System.out.println("topping : 없음");
		}
		else {
			System.out.println("topping : " + String.join("/", topping));
		}
		
		if(side == null) {
			System.out.println("side : 없음");
		}
		else {
			System.out.println("side : " + String.join("/", side));
		}
		
		System.out.println("payment : " + payment);
		
		System.out.println("price : " + price);
		
		// 4) 요청처리 후 사용자가 보게될 응답페이지 (결제페이지) 만들기
		// 응답페이지(jsp)를 선택해서 포워딩
		// 단, 응답페이지에서 필요한 데이터가 있다면 담아서 포워딩 할 것!!
		// request attribute 영역에 담기
		// 어떤 데이터가 필요한지 모르겠다면? => 먼저 jsp를 만들어보기

		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		// 응답할 뷰(jsp) 선택
		RequestDispatcher view =  request.getRequestDispatcher("views/pizza/pizzaShowPage.jsp");
		// 선택된 뷰가 사용자에게 보여지도록 포워딩
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
