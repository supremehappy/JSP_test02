package BookStore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/modify-cart")
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String book_code = request.getParameter("BOOK_CODE");
		String num = request.getParameter("NUM");
		String btn = request.getParameter("BTN");

		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		String id = (String)session.getAttribute("ID");
		
		if(btn.equals("수정")) {
			cart.modifyItem(book_code, num, id);
		}
		else if(btn.equals("삭제")) {
			cart.deleteItem(book_code, id);
		}

		response.sendRedirect("cart-list");
	}

}