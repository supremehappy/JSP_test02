package myhome;

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
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/product-list")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null; PreparedStatement pstmt=null;
		ProductList list = new ProductList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","hr");
			if(con == null) throw new Exception("DB 접속 실패!");
			pstmt = con.prepareStatement(
				"select * from product_info order by pid desc");
			ResultSet rs = pstmt.executeQuery();
			for(int i=0; i<5; i++){
				if( ! rs.next()) break;//반복중단
				//list에 검색된 내용을 담는다.
				list.setPidList(i, rs.getInt("pid"));
				list.setNameList(i, rs.getString("name"));
				list.setPriceList(i, rs.getInt("price"));
				list.setWriterList(i, rs.getString("id"));
				list.setDateList(i, rs.getString("p_date"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{ 
				pstmt.close(); con.close();
			}catch(Exception e){}
		}
		//화면을 게시글 출력 JSP로 바꾸면서 list를 전달한다.
		request.setAttribute("PRODUCT_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=productListView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
