package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 방식으로 요청시 해당 이 doGet 메소드가 자동으로 호출됨
		
		// System.out.println("껐다 켜니까 되네?!?!");
		
		/*
		 * 첫번째 매개변수인 request에는 요청시 전달된 내용들이 담겨있음 (사용자가 입력한 값, 요청전송방식, 요청자의 ip주소 등등...)
		 * 두번째 매개변수인 response 요청처리 후 응답할 때 사용되는 객체
		 * 
		 * 요청처리를 위해서 요청시 전달된 값들 뽑기
		 * request의 parameter 영역 안에 존재
		 * 
		 * 따라서 request의 parameter 영역으로부터 전달된 데이터 뽑는 메소드
		 * > request.getParameter("키값"); : String(그에 해당하는 value 값)
		 * > request.getParameterValues("키값"); : String[] (그에 해당하는 value 값들이 배열에 담겨서 반환)
		 */
		String str = "입력안함";
		int age = 0;
		
		String name = request.getParameter("name"); // "차은우" | ""
		String gender = request.getParameter("gender"); // "M" | "F" | null
		
		if(request.getParameter("age") != "") {
			age = Integer.parseInt(request.getParameter("age")); // "20" => 20 | "" => NumberFormatException 예외발생!! : 빈문자열, 숫자가 아닌 걸로는 변환 불가
		}
		
		String city = request.getParameter("city"); // "파리" => select로 입력 받았기 때문에 입력 안 되는 경우 없음
		double height = Double.parseDouble(request.getParameter("height")); // "160" => 160.0
		
		// 체크박스와 같이 복수개의 value 값들을 뽑고자 할 때
		String[] foods = request.getParameterValues("food"); // ["한식", "일식"] | null
		
		if(name == "") {
			System.out.println("name : " + str);
		}
		else {
			System.out.println("name : " + name);
		}
		
		if(gender == null) {
			System.out.println("gender : " + str);
		}
		else {
			System.out.println("gender : " + gender);
		}
		
		if(age == 0) {
			System.out.println("age : " + str);
		}
		else {
			System.out.println("age : " + age);
		}
		
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		// System.out.println("foods : " + foods); // 주소값 나옴
		// System.out.println("foods : " + foods[0]); // 이건 오류가 날 수도 있음! 만약 아무것도 체크하지 않았을 경우 => NullPointerException
		
		/*
		for(int i = 0; i < foods.length; i++) {
			System.out.println("foods[" + i + "] : " + foods[i]);
		}
		 */
		
		if(foods == null) {
			System.out.println("foods : 선택안함");
		}
		else {
			System.out.println("foods : " + String.join(", ", foods));
		}
		
		// 뽑아낸 값들을 가지고 요청처리 해야됨 (db와 상호작용 : 조회, 삽입, 수정, 삭제..)
		// > Service 메소드 호출 > Dao 메소드 호출 > DB의 sql문 실행
		
		/*
		int result = new MemberService().insertMember(name, gender, age, city, height, foods);
		
		if(result > 0) {
			// 성공 => 성공페이지
		}
		else {
			// 실패 => 실패페이지
		}
		*/
		
		// 위의 요청 처리 후 성공했다는 가정하에 사용자가 보게 될 응답페이지(html) 만들어서 전송
		// 즉, 여기 "Java 코드 내에" 사용자가 보게 될 응답 html 구문 작성할거임!!
		
		// 장점 : Java 코드 내에 작성하기 때문에 반복문, 조건문, 유용한 메소드 등을 활용하기 용이함
		// 단점 : 불편함, 복잡함, 혹시라도 나중에 html을 수정한다면 Java 코드를 수정하는 것과 같아서
		//		다시 반영하고자 한다면 서버를 재실행 해야됨
		
		// * response 객체를 통해 사용자에게 html(응답화면) 전달
		
		// 1) 이제부터 내가 출력할 내용은 문서형태가 html이고 문자 인코딩(문자셋) utf-8이라는 것을 선언
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답하고자 하는 사용자(요청했던 사용자)와의 스트림(클라이언트와의 통로) 생성
		PrintWriter out = response.getWriter();
		
		// 3) 방금 만든 스트림을 통해서 응답 html 구문을 한 줄씩 출력
		out.println("<html>");
				
		out.println("<head>");
		
		out.println("<style>");
		
		out.println("h2 {color:red}");
		out.println("#name {color:orange}");
		out.println("#age {color:yellow}");
		out.println("#city {color:green}");
		out.println("#gender {color:blue}");
		out.println("#height {color:purple}");
		out.println("#foods {color:pink}");
		out.println("ul {list-style:none}");
		
		out.println("</style>");
		
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h2>개인정보 응답화면</h2>");
//		out.println("<span>" + name + " 님은</span>");
		
		if(name == "") {
			out.print("미선택 님은 ");
		}
		else {
			out.printf("<span id='name'>%s</span> 님은 ", name);
		}
		
		out.printf("<span id='age'>%d</span>살이며, ", age);
		out.printf("<span id='city'>%s</span>에 살고, ", city);
		out.printf("키는 <span id='height'>%.1f</span>cm이며, ", height);
		
		out.print("성별은 ");
		
		if(gender == null) {
			out.println("선택을 안 했습니다.");
		}
		else if(gender.equals("M")) {
			out.println("<span id='gender'>남자</span>입니다.");
		}
		else {
			out.println("<span id='gender'>여자</span>입니다.");
		}
		
		out.print("<br> 좋아하는 음식은 ");
		
		if(foods == null) {
			out.println("미선택");
		}
		else { // ["한식", "중식"]
			out.print("<ul>");
			
			/*
			for(int i = 0; i < foods.length -1; i++) {
				out.println("<li>" + foods[i] + ",</li>");
			}
			
			out.println("<li>" + foods[foods.length -1] + "</li>");
			*/
			
			out.println("<li>" + String.join(", ", foods) + "</li>");
			
			out.print("</ul>");
		}
		
		out.println("입니다.");
		
		out.println("</body>");
		
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
