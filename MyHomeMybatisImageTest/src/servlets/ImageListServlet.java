package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudImage;
import model.Writing;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/image-list")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudImage crud = new CrudImage();
		int count = crud.selectImageCount();
		int totalPageCount=0;
		
		if(count>0){
			totalPageCount=count/5;
			
			if(count %5 >0) totalPageCount++;
		}
		
		List<Writing> list = crud.selectImageList();
		request.setAttribute("LIST", list);
		request.setAttribute("pageCount", totalPageCount);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=list_view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}










