package myHome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
//@WebServlet("/loginServlet")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String msg="";
		
		if(checkLogin(id,pw)){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			CartList list = selectCart(id);//계정으로 장바구니 정보검색
			
			if(list != null){// 장바구니에 정보가 있을 경우
				Cart cart= new Cart();
				
				// CartList 에 있는 상품번호, 상품갯수를 Cart에 저장
				// ArrayList -> Array 로 변환
				Integer[] c = list.getCodeList();
				Integer[] n = list.getNumList();
				
				for(int i =0;i<list.getItemSize();i++){
				
					cart.setCodeList(c[i]);
					cart.setNumList(n[i]);
					
				}
				session.setAttribute("CART", cart);
			}
			
			msg="ok";
		}else{
			msg="no";
		}
		response.sendRedirect("templat.jsp?BODY=loginResult.jsp?RESULT="+msg);
	}
	
	private CartList selectCart(String id) throws ServletException{
		
		Connection conn=null; Statement stmt = null;
		CartList list = new CartList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			
			String sql = "select c.code, c.num, p.price, p.name from cart c ,product_info p where c.code=p.pid and c.id='"+id+"'";
			ResultSet rs= stmt.executeQuery(sql);
			
			int loop=0;
			
			while(rs.next()){
				
				list.setCodeList(loop, rs.getInt("code"));
				list.setNumList(loop, rs.getInt("num"));
				list.setNameList(loop, rs.getString("name"));
				list.setPriceList(loop, rs.getInt("price"));
				
				loop++;
			}
			
		}catch(Exception e){
			throw new ServletException(e); 
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
		return list;
	}
	
	private boolean checkLogin(String id, String pw) throws ServletException{
		
		Connection conn=null;
		Statement stmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("select password from user_info where id='"+id+"'");
			
			if(!rs.next()) return false;
			String pass = rs.getString("password");
			
			if(pass.equals(pw)) return true;
			else return false;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
		
		return true;
	}

}
	