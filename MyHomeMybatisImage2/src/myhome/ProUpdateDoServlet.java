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
 * Servlet implementation class ProDoServlet
 */
@WebServlet("/proupdate.do")
public class ProUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProUpdateDoServlet() {
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
				
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		String content = request.getParameter("content");
		String pwd = request.getParameter("password");
		
		String result = "";
		
		CrudHome crud = new CrudHome();
		ProItem pro = crud.selectProInfo(Integer.parseInt(id));
			
			if(pro.getPassword().equals(pwd)){//��ȣ�� ��ġ�ϴ� ���
				pro.setName(name);
				pro.setId(id);
				pro.setPrice(price);
				pro.setContent(content);
				
				int r = crud.updateProInfo(pro);
				r = crud.updateProContent(pro);
				if(r < 0) throw new ServletException("���� DB �۾� �� ����!");
			}else{//��ȣ�� ��ġ���� �ʴ� ���
				result = "?id="+id;
			}
		
		//������ ��ȯ(Redirect�� �ٲ۴�.)
		String url = "template.jsp?BODY=proUpdate_result.jsp"+result;
		response.sendRedirect(url);
	}

}
