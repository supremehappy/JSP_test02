package bookStore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudHome;
import model.UserInfo;

/**
 * Servlet implementation class UserPostServlet
 */
@WebServlet("/user")
public class UserPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPostServlet() {
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
		
		HttpSession session = request.getSession();
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");		
		String name=request.getParameter("NAME");
		String addr=request.getParameter("ADDR");
		String tel=request.getParameter("TEL");
		String email=request.getParameter("EMAIL");
		String age=request.getParameter("AGE");
						
		CrudHome crud = new CrudHome();		
		
		UserInfo user=new UserInfo();
		
		user.setId(id); user.setPw(pw);
		user.setName(name); user.setAddr(addr);
		user.setTel(tel); user.setEmail(email);
		user.setAge(Integer.parseInt(age));
		
		
		int result = crud.insertUser(user);
		if(result < 0) throw new ServletException("글 올리는 도중 문제발생!");
		//글 목록을 보여주는 서블릿을 호출
		response.sendRedirect("index.jsp");
		
		
	}

}
