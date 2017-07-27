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
 * Servlet implementation class BBSListServlet
 */
@WebServlet("/bbs-list")
public class BBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn= null;
		PreparedStatement pstmt=null;
		BBSList list = new BBSList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			pstmt= conn.prepareStatement("select * from bbs order by seqno desc");
			ResultSet rs = pstmt.executeQuery();
			
			for(int i =0; i<5 ; i++){
				if(!rs.next()) break;
				
				list.setSeqNoList(i, rs.getInt("seqno"));
				list.setTitleList(i, rs.getString("title"));
				list.setWriterList(i, rs.getString("id"));
				list.setDateList(i, rs.getString("bbs_date"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close(); 
				conn.close();
			}catch(Exception e){}
		}
		
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsListView.jsp");
		
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
