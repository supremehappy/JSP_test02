package myhome;

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

import crud.CrudHome;
import model.BBSItem;
import model.ProItem;

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
		CrudHome crud = new CrudHome();
		int pid = crud.selectMaxPid();
		
		pid = pid +1;
		ProItem pro = new ProItem();
		
		pro.setPid(pid);
		pro.setName(name);
		pro.setPrice(price);
		pro.setP_date(proDate);
		pro.setContent(content);
		pro.setId(id);
		
		int result = crud.insertPro(pro);
		
		if(result <0) throw new ServletException("upload error");
		
		
		response.sendRedirect("pro-list");
	}
}
