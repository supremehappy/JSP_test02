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
		String fileName = "";
		String result = "";
		
		try{
			MultipartRequest multi = new MultipartRequest(request,path,maxLimit,enctype,new DefaultFileRenamePolicy());
				
			String id = multi.getParameter("id");
			String title = multi.getParameter("title");
			String name = multi.getParameter("name");
			String content = multi.getParameter("content");
			String pwd = multi.getParameter("password");
			String email = multi.getParameter("email");
			
			CrudImage crud = new CrudImage();
			Writing writing = crud.selectWritingInfo(Integer.parseInt(id));
			System.out.println("1");
			
			if(writing.getPassword().equals(pwd)){
				writing.setTitle(title);
				writing.setWriter_name(name);
				writing.setEmail(email);
				writing.setContent(content);
				fileName = multi.getFilesystemName("image_name");
				System.out.println("2");
				
				if(fileName!=null){//이미지 변경된 경우
					System.out.println("3");
					writing.setImage_name(fileName);
				}
				System.out.println("4");
				int r = crud.updateWritingInfo(writing);
				System.out.println("5");
				r = crud.updateWritingContent(writing);
				System.out.println("6");
				if(r<0) throw new ServletException("db upload data modify error!");
				System.out.println("7");
			}else{
				result = "?id="+id;
			}
			
		}catch(Exception e){
			throw new ServletException("Modify error");
		}
		
		String url = "template.jsp?BODY=update_result.jsp"+result;
		response.sendRedirect(url);
	}

}
