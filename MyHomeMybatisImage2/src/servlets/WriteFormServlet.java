package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudImage;
import model.Writing;

/**
 * Servlet implementation class WriteFormServlet
 */
@WebServlet("/write-form")
public class WriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parentId = request.getParameter("parentid");
		String groupId = request.getParameter("groupid");
		String title="";
		Writing writing = null;
		
		if(parentId !=null){
			CrudImage crud = new CrudImage();
			
			writing = crud.selectWritingInfo(Integer.parseInt(parentId));
			title = "RE]"+writing.getTitle();
		}
		
		request.setAttribute("writing", writing);
		request.setAttribute("title", title);
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=write_form.jsp");
		
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









