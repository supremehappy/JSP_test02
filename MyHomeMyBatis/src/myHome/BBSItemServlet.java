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
 * Servlet implementation class BBSItemServlet
 */
@WebServlet("/bbsItem")
public class BBSItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seqno = request.getParameter("SEQNO");
		Connection conn=null; Statement stmt = null;
		BBSItem item = new BBSItem();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			
			String sql = "select * from bbs where seqno ="+seqno;
			ResultSet rs= stmt.executeQuery(sql);		
			
			if(rs.next()){
				item.setSeqno(rs.getInt("seqno"));
				item.setTitle(rs.getString("title"));
				item.setContent(rs.getString("content"));
				item.setWriter(rs.getString("id"));
				item.setDate(rs.getString("bbs_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
		
		request.setAttribute("BBS_ITEM", item);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsContentView.jsp");
		
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
