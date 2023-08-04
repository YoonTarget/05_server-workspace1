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
		
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
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
		
		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		
		RequestDispatcher view =  request.getRequestDispatcher("views/pizza/pizzaShowPage.jsp");
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
