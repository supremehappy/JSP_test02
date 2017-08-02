package myhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/add-cart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid= request.getParameter("CODE");
		if(pid == null){
			throw new ServletException("상품 코드가 없습니다.");
		}
		//상품검색을 한다.-> 검색된 정보를 빈에 저장한다.
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		String id = (String)session.getAttribute("ID");
		if(cart == null) cart = new Cart();
		cart.addCart(Integer.parseInt(pid), 1, id);
		session.setAttribute("CART", cart);//카트를 세션에 보관
		response.sendRedirect("addCartResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}










