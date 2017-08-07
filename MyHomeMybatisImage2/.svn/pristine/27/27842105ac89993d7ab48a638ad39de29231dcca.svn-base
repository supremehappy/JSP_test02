package myhome;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
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
	private CartList selectCart(String id) throws ServletException{
		CartList list = new CartList();
		CrudHome crud = new CrudHome();
		List<CartItem> result = crud.selectCart(id);
		int loop = 0; Iterator it = result.iterator();
		while(it.hasNext()){
			CartItem item = (CartItem)it.next();
			list.setCodeList(loop, item.getCode());
			list.setNumList(loop, item.getNum());;
		}
		return list;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		String msg = "";
		if(checkLogin(id,pwd)){//로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("ID", id);
			CartList list = selectCart(id);//계정으로 장바구니정보 검색
			if(list != null){//장바구니 정보가 있는 경우
				Cart cart = new Cart();
				//CartList에 있는 상품번호,상품갯수를 Cart에 저장한다.
				Integer[] c = list.getCodeList();
				Integer[] n = list.getNumList();
				System.out.println("상품갯수:"+list.getItemSize());
				for(int i=0; i<list.getItemSize(); i++){
					cart.setCodeList(c[i]);
					System.out.println("상품번호:"+c[i]);
					cart.setNumList(n[i]);
				}
				session.setAttribute("CART", cart);
			}
			msg = "OK";
		}else{//로그인 실패
			msg = "NOK";
		}
		//페이지를 바꾼다.
		response.sendRedirect("template.jsp?BODY=loginResult.jsp?RESULT="+msg);
	}
	private boolean checkLogin(String id, String pwd)throws ServletException{
		CrudHome crud = new CrudHome();
		UserInfo info = crud.selectMember(id);
		if(info != null){
			if(info.getPassword().equals(pwd)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}



















