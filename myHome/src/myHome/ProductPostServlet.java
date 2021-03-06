package myHome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductPostServlet
 */
@WebServlet("/pro-post")
public class ProductPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPostServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		
		String id = (String)session.getAttribute("id");
		String name = request.getParameter("PRONAME");
		int price = Integer.parseInt(request.getParameter("PROPRICE"));
		String content = request.getParameter("CONTENT");
		
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int day = today.get(Calendar.DATE);
		String proDate = year+"년 "+month+"월 "+day+"일 ";
		
		Connection conn= null;
		Statement stmt = null;
		int pid=1;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			
			ResultSet rs= stmt.executeQuery("select max(pid) as max_no from product_info");
			
			if(rs.next()) pid=1+rs.getInt("max_no");
			String sql = "insert into product_info values("+pid+",'"+name+"','"+price+"','"+proDate+"','"+content+"','"+id+"')";
			stmt.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
		
		response.sendRedirect("pro-list");
	}
}
