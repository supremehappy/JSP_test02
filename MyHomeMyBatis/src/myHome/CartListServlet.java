package myHome;

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

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/cart-list")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("CART");
		String id = (String)session.getAttribute("id");
		
		if(cart != null){//카트가 있다면
			CartList list = readDB(id);
			request.setAttribute("CART_LIST", list);
		}else{ //카트가 없다면
			request.setAttribute("CART_LIST", null);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("templat.jsp?BODY=cartListView.jsp");
		rd.forward(request, response);
		
	}

	private CartList readDB(String id)throws ServletException{
		CartList list = new CartList();
		CrudHome crud=new CrudHome();
		
		System.out.println("CartListServlet : "+id);
		
		List<CartItem> result = crud.selectCart(id);
		Iterator it = result.iterator();
		
		int loop=0;
		
		while(it.hasNext()){
			CartItem item = (CartItem)it.next();
			
			list.setCodeList(loop, item.getCode());
			list.setNumList(loop, item.getNum());
			list.setNameList(loop, item.getName());
			list.setPriceList(loop, item.getPrice());
			
			System.out.println("setCodeList : "+loop+", "+ item.getCode());
			System.out.println("setNumList : "+loop+", "+ item.getNum());
			System.out.println("setNameList : "+loop+", "+ item.getName());
			System.out.println("setPriceList : "+loop+", "+ item.getPrice());
			
			loop++;
		}
		
		return list;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
