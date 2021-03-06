package myHome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private void readBBS(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
			
			if(!rs.next()) list.setLastPage(true);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close(); 
				conn.close();
			}catch(Exception e){}
		}
		
		list.setFirstPage(true);
		
		int pageNum = readPageNum();
		list.setPageNum(pageNum);
		
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsListView.jsp");
		
		dis.forward(request, response);
    }
    
    private void readNextPage(String lastSeqNo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Connection conn= null;
		Statement stmt=null;
		BBSList list = new BBSList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bbs where seqno< "+lastSeqNo+"order by seqno desc");
			
			for(int i =0; i<5 ; i++){
				if(!rs.next()) break;
				
				list.setSeqNoList(i, rs.getInt("seqno"));
				list.setTitleList(i, rs.getString("title"));
				list.setWriterList(i, rs.getString("id"));
				list.setDateList(i, rs.getString("bbs_date"));
			}
			
			if(!rs.next()) list.setLastPage(true);
			
			int pageNum = readPageNum();
			list.setPageNum(pageNum);
			
			request.setAttribute("BBS_LIST", list);
			RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsListView.jsp");
			
			dis.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close(); 
				conn.close();
			}catch(Exception e){}
		}    	
    }
    
    private void readPrevPage(String firstSeqNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection conn= null;
		PreparedStatement pstmt=null;
		BBSList list = new BBSList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			String sql = "select * from bbs where seqno > "+ firstSeqNo + " order by seqno desc";
			pstmt= conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.last()) throw new ServletException(); //맨 마지막 행으로 이동
			
			int rows = rs.getRow(); //마지막행 번호 읽음
			
			rs.absolute(rows-4); // 위로 4칸 이동
						
			for(int i =0; i<5 ; i++){
				list.setSeqNoList(i, rs.getInt("seqno"));
				list.setTitleList(i, rs.getString("title"));
				list.setWriterList(i, rs.getString("id"));
				list.setDateList(i, rs.getString("bbs_date"));
				
				if(!rs.next()) break;
			}
			
			if((rows-5)<5) list.setFirstPage(true); // 첫번째 페이지인지 검사
			
			int pageNum = readPageNum();
			list.setPageNum(pageNum);
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
    
    private void readPage(String pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Connection conn= null;
		PreparedStatement pstmt=null;
		BBSList list = new BBSList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			String sql = "select * from bbs order by seqno desc";
			pstmt= conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			int page = Integer.parseInt(pageNo);
			
			if(page > 1) rs.absolute((page-1)*5);
						
			for(int i =0; i<5 ; i++){
				if(!rs.next()) break;
				
				list.setSeqNoList(i, rs.getInt("seqno"));
				list.setTitleList(i, rs.getString("title"));
				list.setWriterList(i, rs.getString("id"));
				list.setDateList(i, rs.getString("bbs_date"));
			}
			
			if(page==1) list.setFirstPage(true);
			if(!rs.next()) list.setLastPage(true);
			
			int pageNum = readPageNum();
			list.setPageNum(pageNum);
			
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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lastSeqNo = request.getParameter("LAST_SEQNO");
		String firstSeqNo = request.getParameter("FIRST_SEQNO");		
		String pageNo = request.getParameter("PAGE_NO");
		
		if(pageNo!=null){
			readPage(pageNo, request, response);
		}else if(lastSeqNo !=null){
			readNextPage(lastSeqNo,request,response);
		}else if(firstSeqNo!=null){
			readPrevPage(firstSeqNo, request, response);
		}else{
			readBBS(request,response);
		}
	}

	private int readPageNum(){
		
		int pageNum=0;
		
		Connection conn= null;
		Statement stmt=null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery("select count(*) as num from bbs");
			
			if(!rs.next()) return 0;
			pageNum = rs.getInt("num");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close(); 
				conn.close();
			}catch(Exception e){}
		}
		
		return (pageNum+4)/5;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
