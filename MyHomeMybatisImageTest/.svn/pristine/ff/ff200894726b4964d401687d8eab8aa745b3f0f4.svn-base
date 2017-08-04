package servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import crud.CrudImage;
import model.IdSequence;
import model.Writing;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/write.do")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		request.setCharacterEncoding("euc-kr");
		String savePath="uploadfiles";
		int max_limit = 5*1024*1024;
		String encType="euc-kr";
		ServletContext context = this.getServletContext();
		String path=context.getRealPath(savePath);
		String fileName="";
		try{
			MultipartRequest multi = new MultipartRequest(
				request,path,max_limit,encType,
				new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("imagename");
			if(fileName == null){
				throw new ServletException("업로드 중 문제발생");
			}else{
				////////날짜 구함///////
				Calendar today = Calendar.getInstance();
				int year = today.get(Calendar.YEAR);
				int month=today.get(Calendar.MONTH)+1;
				int date=today.get(Calendar.DATE);
				String register_date=year+"/"+month+"/"+date+"/";
				int hour=today.get(Calendar.HOUR_OF_DAY);//24시간제
				int min=today.get(Calendar.MINUTE);
				int sec=today.get(Calendar.SECOND);
				register_date=register_date+":"+hour+":"+min+":"+sec;
				////////////////////////
				String title=multi.getParameter("title");
				String nick=multi.getParameter("nick");
				String email=multi.getParameter("email");
				String pwd=multi.getParameter("password");
				String content=multi.getParameter("content");
				Writing writing = new Writing();
				writing.setTitle(title);
				writing.setWriter_name(nick);
				writing.setEmail(email);
				writing.setPassword(pwd);
				writing.setContent(content);
				writing.setImage_name(fileName);
				writing.setRegister_date(register_date);
				CrudImage crud = new CrudImage();
				int seqno = crud.selectLastId("writing_info");
				seqno = seqno + 1;
				IdSequence seq = new IdSequence();
				seq.setLast_id(seqno);seq.setName("writing_info");
				if(seqno == 1){
					crud.insertLastId(seq);//새로운 글번호 삽입
				} else {
					crud.updateLastId(seq);//글번호 변경
				}
				writing.setWriting_id(seqno);//새이미지글에 글번호 삽입
				int result = crud.insertWrtingInfo(writing);//새글삽입
				result = crud.insertWritingContent(writing);
				if(result < 0) throw new ServletException(
						"writing_info 테이블에 삽입 중 예외");
				
			}
		}catch(Exception e){
			throw new ServletException(e);
		}
		//페이지 전환
		response.sendRedirect("image-list");
	}

}




















