package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import crud.CrudImage;
import model.Writing;

/**
 * Servlet implementation class UpdateDoServlet
 */
@WebServlet("/update.do")
public class UpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoServlet() {
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
		String savePath = "uploadfiles";
		int maxLimit = 5 * 1024 * 1024;
		String enctype = "UTF-8";
		ServletContext context = this.getServletContext();
		String path = context.getRealPath(savePath);
		String fileName = "";String result = "";
		try{
			MultipartRequest multi = new MultipartRequest(
				request,path,maxLimit,enctype,
				new DefaultFileRenamePolicy());
			String id = multi.getParameter("id");
			System.out.println("UpdateDoServlet id :"+id);
			String title = multi.getParameter("title");
			String name = multi.getParameter("name");
			String content = multi.getParameter("content");
			String pwd = multi.getParameter("password");
			String email = multi.getParameter("email");
			CrudImage crud = new CrudImage();
			Writing writing = crud.selectWritingInfo(
					Integer.parseInt(id));
			
			if(writing.getPassword().equals(pwd)){//��ȣ�� ��ġ�ϴ� ���
				writing.setTitle(title);
				writing.setWriter_name(name);
				writing.setEmail(email);
				writing.setContent(content);
				fileName = multi.getFilesystemName("image_name");
				if(fileName != null){//�̹����� ����� ���
					writing.setImage_name(fileName);
				}
				//writing_info�� writing_content���̺� update
				int r = crud.updateWritingInfo(writing);
				r = crud.updateWritingContent(writing);
				if(r < 0)
					throw new ServletException("���� DB �۾� �� ����!");
			}else{//��ȣ�� ��ġ���� �ʴ� ���
				result = "?id="+id;
			}
		}catch(Exception e){
			throw new ServletException("���� �۾� �� ����!");
		}
		//������ ��ȯ(Redirect�� �ٲ۴�.)
		String url = "template.jsp?BODY=update_result.jsp"+result;
		response.sendRedirect(url);
	}

}


















