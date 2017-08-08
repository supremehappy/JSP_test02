package myhome;

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

import crud.CrudHome;
import model.BBSItem;
import model.ProItem;

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

		String pid = request.getParameter("id");
		CrudHome crud = new CrudHome();
		ProItem pro = crud.selectProInfo(Integer.parseInt(pid));
		String content = crud.selectProContent(Integer.parseInt(pid));
		
		pro.setContent(content);
		request.setAttribute("pro", pro);		
		request.setAttribute("PRO_ITEM", pro);
		
		RequestDispatcher dis = request.getRequestDispatcher("template.jsp?BODY=ProContentView.jsp");
		
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid = request.getParameter("id");
		CrudHome crud = new CrudHome();
		ProItem pro = crud.selectProInfo(Integer.parseInt(pid));
		String content = crud.selectProContent(Integer.parseInt(pid));
		
		pro.setContent(content);
		request.setAttribute("pro", pro);		
		request.setAttribute("PRO_ITEM", pro);
		
		RequestDispatcher dis = request.getRequestDispatcher("template.jsp?BODY=ProContentView.jsp");
		
		dis.forward(request, response);
	}

}
