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
 * Servlet implementation class ProFromServlet
 */
@WebServlet("/pro-form")
public class ProFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProFromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parentId = request.getParameter("parentid");
		System.out.println("ProFromServlet parentId : "+parentId);
		String groupId = request.getParameter("groupid");
		System.out.println("ProFromServlet groupId : "+groupId);
		String title="";
		ProItem pro = null;
		
		if(parentId !=null){
			CrudHome crud = new CrudHome();
			
			pro = crud.selectProInfo(Integer.parseInt(parentId));
			title = "RE]"+pro.getName();
		}
		
		request.setAttribute("pro", pro);
		request.setAttribute("title", title);
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=productInput.jsp");
		
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
