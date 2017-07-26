package myHome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
			msg="ok";
		}else{
			msg="no";
		}
		response.sendRedirect("templat.jsp?BODY=loginResult.jsp?RESULT="+msg);
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
	