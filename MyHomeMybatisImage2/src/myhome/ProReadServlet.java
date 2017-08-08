package myhome;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudHome;
import model.ProItem;

/**
 * Servlet implementation class ProReadServlet
 */
@WebServlet("/pro-read")
public class ProReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		CrudHome crud = new CrudHome();
		ProItem pro = crud.selectProInfo(Integer.parseInt(id));
		String content = crud.selectProContent(Integer.parseInt(id));
		
		pro.setContent(content);//�� ���� ����
		request.setAttribute("pro", pro);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=ProContentView.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		CrudHome crud = new CrudHome();
		ProItem pro = crud.selectProInfo(Integer.parseInt(id));
		String content = crud.selectProContent(Integer.parseInt(id));
		
		pro.setContent(content);//�� ���� ����
		request.setAttribute("pro", pro);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=ProContentView.jsp");
		rd.forward(request, response);
	}

}
