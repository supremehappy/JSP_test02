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

/**
 * Servlet implementation class ProItemServlet
 */
@WebServlet("/proitem")
public class ProItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pid = request.getParameter("PID");
		Connection conn=null; Statement stmt = null;
		ProItem item = new ProItem();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			
			String sql = "select * from product_info where pid ="+pid;
			ResultSet rs= stmt.executeQuery(sql);		
			
			if(rs.next()){
				item.setPid(rs.getInt("pid"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setContent(rs.getString("content"));
				item.setDate(rs.getString("p_date"));
				item.setWriter(rs.getString("id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
		
		request.setAttribute("PRO_ITEM", item);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=ProContentView.jsp");
		
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
