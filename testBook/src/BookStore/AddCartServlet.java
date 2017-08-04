package BookStore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add-cart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_code = request.getParameter("BOOK_CODE");
		
		if(book_code == null){
			throw new ServletException("상품 코드가 없습니다.");
		}
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
		String id = (String) session.getAttribute("ID");
		
		if(cart == null) {
			cart = new Cart();
		}
		
		cart.addCart(Integer.parseInt(book_code), 1, id);
		
		session.setAttribute("CART", cart);
		response.sendRedirect("addCartResult.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
