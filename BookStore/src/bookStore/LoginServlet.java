package bookStore;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudHome;
import model.CartItem;
import model.UserInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	private CartList selectCart(String id) throws ServletException {
		CartList cartList = new CartList();
		CrudHome crud =  new CrudHome();
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
		
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		String msg = "";
		
		if(checkLogin(id,pwd)){
			HttpSession session = request.getSession();
			session.setAttribute("ID", id);
			CartList list = selectCart(id);
			
			if(list != null){
				Cart cart = new Cart();
				Integer[] c = list.getBook_codeList();
				Integer[] n = list.getNumList();
				
				for(int i=0; i<list.getListSize(); i++){
					cart.setCodeList(c[i]);
					cart.setNumList(n[i]);
				}
				session.setAttribute("CART", cart);
			}
			msg = "OK";
		}else{
			msg = "NOK";
		}
		
		response.sendRedirect("index.jsp?BODY=loginResult.jsp?RESULT="+msg);
		
	}
	
	private boolean checkLogin(String id, String pwd)throws ServletException{
		CrudHome crud = new CrudHome();
		UserInfo info = crud.selectMember(id);
				
		if(info != null){
			if(info.getPw().equals(pwd)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}