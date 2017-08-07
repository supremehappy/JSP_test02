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
 * Servlet implementation class ImageReadServlet
 */
@WebServlet("/image-read")
public class ImageReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageReadServlet() {
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
		
		String id = request.getParameter("id");
		CrudImage crud = new CrudImage();
		Writing writing = crud.selectWritingInfo(Integer.parseInt(id));
		String content = crud.selectWritingContent(Integer.parseInt(id));
		
		writing.setContent(content);
		request.setAttribute("writing", writing);
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp?BODY=read_image.jsp");
		rd.forward(request, response);
	}

}













