package upload;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		
		String savePath="upload"; // 이미지 저장할 폴더 이름
		int uploadLimit = 5*1024*1024; // 이미지 용량 제한
		String encType="UTF-8";
		
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(savePath);//이미지 저장되는 경로
		String fileName="";		
		
		try{
			//MultipartRequest 파일 업로드 객체 / DefaultFileRenamePolicy() 업로드 파일 이름 처리 메소드
			MultipartRequest multi = new MultipartRequest(request,uploadPath,uploadLimit,encType, new DefaultFileRenamePolicy());
			
			fileName = multi.getFilesystemName("FILE_NAME");
			
			if(fileName==null){
				System.out.println("upload fail");
			}else{
				System.out.println("path & filename : "+uploadPath+"/"+fileName);
			}
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		// 페이지 변경
		String encoded = URLEncoder.encode(fileName,"UTF-8");
		response.sendRedirect("result.jsp?UPLOAD="+encoded);
	}

}
