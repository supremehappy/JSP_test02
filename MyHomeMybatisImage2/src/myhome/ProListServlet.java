package myhome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudHome;
import crud.CrudImage;
import model.BBSItem;
import model.Condition;
import model.ProItem;
import model.Writing;

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
		
		ProList proList = new ProList();
    	CrudHome crud = new CrudHome();
    	int count = crud.selectProPageNum();
		int totalPageCount = 0;
		int startRow = 0; int endRow = 0;
		String pageNum = request.getParameter("page");
		if(pageNum == null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
    	
		if(count > 0){
			totalPageCount = count / 5;
			if(count % 5 > 0) totalPageCount++;
			startRow = (currentPage - 1)*5 + 1;
			endRow = currentPage * 5;
			if(endRow > count){
				endRow = count;
			}
		}
		
		Condition c = new Condition();
		c.setStartRow(startRow); c.setEndRow(endRow);
		List<ProItem> list = crud.selectProListCondition(c);
    	
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", totalPageCount);
		request.setAttribute("LIST", list);
		
		request.setAttribute("PRO_LIST", proList);
		RequestDispatcher dis = request.getRequestDispatcher("template.jsp?BODY=proListView.jsp");
		
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
