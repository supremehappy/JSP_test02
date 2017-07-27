package myHome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProListServlet
 */
@WebServlet("/pro-list")
public class ProListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ProList list = new ProList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			pstmt= conn.prepareStatement("select * from product_info order by pid desc");
			ResultSet rs = pstmt.executeQuery();
			
			for(int i =0; i<5 ; i++){
				if(!rs.next()) break;
				
				list.setProList(i, rs.getInt("pid"));
				list.setNameList(i, rs.getString("name"));
				list.setPriceList(i, rs.getInt("price"));
				list.setDateList(i, rs.getString("p_date"));
				list.setWriterList(i, rs.getString("id"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close(); 
				conn.close();
			}catch(Exception e){}
		}
		
		request.setAttribute("PRO_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=proListView.jsp");
		
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
