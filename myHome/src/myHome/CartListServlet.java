package myHome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if(cart != null){//카트가 있다면
			CartList list = readDB(cart);
			request.setAttribute("CART_LIST", list);
		}else{ //카트가 없다면
			request.setAttribute("CART_LIST", null);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("templat.jsp?BODY=cartListView.jsp");
		rd.forward(request, response);
		
	}

	private CartList readDB(Cart cart)throws ServletException{
		CartList list = new CartList();
		Connection conn=null; Statement stmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");			
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
		
			int itemNum = cart.getItemSize();
			
			for(int i = 0; i<itemNum; i++){
				
				int code=cart.getCode(i);
				int num = cart.getNum(i);
				
				String sql="select name,price from product_info where pid="+code;
				ResultSet rs = stmt.executeQuery(sql);
				
				if(!rs.next()) throw new ServletException("no!");
				
				list.setCodeList(i, code);
				list.setPriceList(i, rs.getInt("price"));
				list.setNameList(i, rs.getString("name"));
				list.setNumList(i, num);
				
			}
		}catch(Exception e){ 
			
		}finally{
			try{
				conn.close(); stmt.close();
			}catch(Exception e){}
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
