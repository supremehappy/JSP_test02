package myhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyCartServlet
 */
@WebServlet("/modify-cart")
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String code = request.getParameter("CODE");
		String num = request.getParameter("NUMBER");
		//삭제버튼 을 누른경우, 수정버튼 을 누른경우
		String btn = request.getParameter("BTN");
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		String id = (String)session.getAttribute("ID");
		if(btn.equals("수정")){
			//Cart에 있는 상품 중 전달된 상품코드와 일치하는 상품의 갯수를 변경
			cart.modifyItem(code, num, id);
		}else if(btn.equals("삭제")){
			//Cart에 있는 상품 중 전달된 상품코드와 일치하는 상품 삭제, 상품의 갯수도 삭제
			cart.deleteItem(code,id);
		}
		//화면 전환(장바구니 목록)
		response.sendRedirect("cart-list");
	}

}


















