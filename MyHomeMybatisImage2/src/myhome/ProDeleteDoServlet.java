package myhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudHome;
import model.ProItem;

/**
 * Servlet implementation class ProDeleteDoServlet
 */
@WebServlet("/prodelete.do")
public class ProDeleteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProDeleteDoServlet() {
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
		CrudHome crud = new CrudHome();
		ProItem org = crud.selectProInfo(Integer.parseInt(id));
		String url="";//�̵��� ������
		
		if(org.getPassword().equals(pwd)){//��ȣ�� ��ġ�ϴ� ���
			
			int result = crud.deleteProInfo(Integer.parseInt(id));
			
			result = crud.deleteProContent(Integer.parseInt(id));
			
			if(result < 0) throw new ServletException("���� �� ����");
			
			url="template.jsp?BODY=proDelete_result.jsp";
		}else{//��ġ���� �ʴ� ���
			
			url="template.jsp?BODY=proDelete_result.jsp?id="+id;
		}
		response.sendRedirect(url);
	}

}
