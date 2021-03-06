package myHome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class modifyCartServlet
 */
@WebServlet("/modify-cart")
public class modifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyCartServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		String code=request.getParameter("CODE");
		String num = request.getParameter("NUMBER");
		String btn = request.getParameter("BTN");
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
		
		String id = (String)session.getAttribute("id");
		
		if(btn.equals("수정")){
			//Cart 에 담긴 상품 중 전달된 상품코드와 일치하는 상품의 갯수를 변경
			cart.modifyItem(code, num, id);
		}else if(btn.equals("삭제")){
			//Cart 에 담긴 상품 중 전달된 상품코드와 일치하는 상품과 갯수를 삭제
			cart.deleteItem(code);
		}
		response.sendRedirect("cart-list");
	}

}
