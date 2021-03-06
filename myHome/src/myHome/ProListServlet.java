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
    private void readBBS(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
		
		list.setFirstPage(true);
		
		int pageNum = readPageNum();
		list.setPageNum(pageNum);
		
		request.setAttribute("PRO_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=proListView.jsp");
		
		dis.forward(request, response);
    }
    
    private void readNextPage(String lastPid,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Connection conn= null;
		Statement stmt=null;
		ProList list = new ProList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product_info where pid< "+lastPid+"order by pid desc");
			
			for(int i =0; i<5 ; i++){
				if(!rs.next()) break;
				
				list.setProList(i, rs.getInt("pid"));
				list.setNameList(i, rs.getString("name"));
				list.setPriceList(i, rs.getInt("price"));
				list.setDateList(i, rs.getString("p_date"));
				list.setWriterList(i, rs.getString("id"));
			}
			
			if(!rs.next()) list.setLastPage(true);
			
			int pageNum = readPageNum();
			list.setPageNum(pageNum);
			
			request.setAttribute("PRO_LIST", list);
			RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=proListView.jsp");
			
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
    
    private void readPrevPage(String firstPid, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection conn= null;
		PreparedStatement pstmt=null;
		ProList list = new ProList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			String sql = "select * from product_info where pid > "+ firstPid + " order by pid desc";
			pstmt= conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.last()) throw new ServletException(); //맨 마지막 행으로 이동
			
			int rows = rs.getRow(); //마지막행 번호 읽음
			
			rs.absolute(rows-4); // 위로 4칸 이동
						
			for(int i =0; i<5 ; i++){
				list.setProList(i, rs.getInt("pid"));
				list.setNameList(i, rs.getString("name"));
				list.setPriceList(i, rs.getInt("price"));
				list.setDateList(i, rs.getString("p_date"));
				list.setWriterList(i, rs.getString("id"));
				
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
		
		request.setAttribute("PRO_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=proListView.jsp");
		
		dis.forward(request, response);
    }
    
    private void readPage(String pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Connection conn= null;
		PreparedStatement pstmt=null;
		ProList list = new ProList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			
			String sql = "select * from product_info order by pid desc";
			pstmt= conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			int page = Integer.parseInt(pageNo);
			
			if(page > 1) rs.absolute((page-1)*5);
						
			for(int i =0; i<5 ; i++){
				if(!rs.next()) break;
				
				list.setProList(i, rs.getInt("pid"));
				list.setNameList(i, rs.getString("name"));
				list.setPriceList(i, rs.getInt("price"));
				list.setDateList(i, rs.getString("p_date"));
				list.setWriterList(i, rs.getString("id"));
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
		
		request.setAttribute("PRO_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=proListView.jsp");
		
		dis.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lastPid = request.getParameter("LAST_PID");
		String firstPid = request.getParameter("FIRST_PID");		
		String pageNo = request.getParameter("PAGE_NO");
		
		if(pageNo!=null){
			readPage(pageNo, request, response);
		}else if(lastPid !=null){
			readNextPage(lastPid,request,response);
		}else if(firstPid!=null){
			readPrevPage(firstPid, request, response);
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
			ResultSet rs = stmt.executeQuery("select count(*) as num from product_info");
			
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
