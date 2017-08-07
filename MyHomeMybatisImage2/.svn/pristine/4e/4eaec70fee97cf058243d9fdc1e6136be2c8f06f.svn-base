package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudImage;
import model.Writing;

/**
 * Servlet implementation class DeleteDoServlet
 */
@WebServlet("/delete.do")
public class DeleteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoServlet() {
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
		String pwd = request.getParameter("password");
		CrudImage crud = new CrudImage();
		Writing org = crud.selectWritingInfo(Integer.parseInt(id));
		String url="";//이동할 페이지
		if(org.getPassword().equals(pwd)){//암호가 일치하는 경우
			System.out.println("입력한 pwd:"+pwd);
			int result = crud.deleteWritingInfo(Integer.parseInt(id));
			result = crud.deleteWritingContent(Integer.parseInt(id));
			if(result < 0) throw new ServletException("삭제 중 예외");
			url="template.jsp?BODY=delete_result.jsp";
		}else{//일치하지 않는 경우
			System.out.println("암호 불일치");
			url="template.jsp?BODY=delete_result.jsp?id="+id;
		}
		response.sendRedirect(url);
	}

}
















