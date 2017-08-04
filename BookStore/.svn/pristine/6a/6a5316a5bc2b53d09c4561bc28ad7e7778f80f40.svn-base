package bookStore;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudHome;
import model.CartItem;

@WebServlet("/cart-list")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
		String id = (String) session.getAttribute("ID");
		
		if(cart != null) {
			CartList cartList = readDB(id);
			request.setAttribute("CART_LIST", cartList);
		}
		else {
			request.setAttribute("CART_LIST", null);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?BODY=cartListView.jsp");
		rd.forward(request, response);
	}

	private CartList readDB(String id) throws ServletException {
		CartList cartList = new CartList();
		CrudHome crud = new CrudHome();
		List<CartItem> result = crud.selectCart(id);
		
		int loop = 0;
		Iterator it = result.iterator();
		
		while(it.hasNext()) {
			CartItem item = (CartItem) it.next();
			cartList.setCart_noList(loop, item.getCart_no());
			cartList.setBook_codeList(loop, item.getBook_code());
			cartList.setBook_titleList(loop, item.getBook_title());
			cartList.setNumList(loop, item.getNum());
			cartList.setPriceList(loop, item.getPrice());
			cartList.setIdList(loop, item.getId());
			loop++;
		}
		
		return cartList;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
