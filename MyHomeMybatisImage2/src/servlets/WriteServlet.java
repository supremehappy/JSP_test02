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
		request.setCharacterEncoding("UTF-8");
		String savePath="uploadfiles";
		int max_limit = 5*1024*1024;
		String encType="UTF-8";
		ServletContext context = this.getServletContext();
		String path=context.getRealPath(savePath);
		String fileName="";
		CrudImage crud = new CrudImage();
		
		try{
			MultipartRequest multi = new MultipartRequest(
				request,path,max_limit,encType,
				new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("imagename");
			
			if(fileName == null){
				throw new ServletException("���ε� �� �����߻�");
			}else{
				String parentId = multi.getParameter("parentid");
				String groupId = multi.getParameter("groupid");
				String orderNo = multi.getParameter("orderno");
				Writing writing = new Writing();
				
				if((parentId==null)||(parentId.equals(""))){ // 원글
					writing.setParent_id(0);
					writing.setOrder_no(0);
					writing.setGroup_id(crud.selectMaxGroupId()+1);
					
				}else{ // 답글
					writing.setParent_id(Integer.parseInt(parentId));
					writing.setGroup_id(Integer.parseInt(groupId));
					writing.setOrder_no(Integer.parseInt(orderNo));
					
					
				}
				
				////////��¥ ����///////
				Calendar today = Calendar.getInstance();
				int year = today.get(Calendar.YEAR);
				int month=today.get(Calendar.MONTH)+1;
				int date=today.get(Calendar.DATE);
				String register_date=year+"/"+month+"/"+date+"/";
				int hour=today.get(Calendar.HOUR_OF_DAY);//24�ð���
				int min=today.get(Calendar.MINUTE);
				int sec=today.get(Calendar.SECOND);
				register_date=register_date+":"+hour+":"+min+":"+sec;
				////////////////////////
				String title=multi.getParameter("title");
				String nick=multi.getParameter("nick");
				String email=multi.getParameter("email");
				String pwd=multi.getParameter("password");
				String content=multi.getParameter("content");
				
				writing.setTitle(title);
				writing.setWriter_name(nick);
				writing.setEmail(email);
				writing.setPassword(pwd);
				writing.setContent(content);
				writing.setImage_name(fileName);
				writing.setRegister_date(register_date);				
				
				int seqno = crud.selectLastId("writing_info");
				
				seqno = seqno + 1;
				
				IdSequence seq = new IdSequence();
				
				seq.setLast_id(seqno);seq.setName("writing_info");
				
				if(seqno == 1){
					crud.insertLastId(seq);//���ο� �۹�ȣ ����
				} else {
					crud.updateLastId(seq);//�۹�ȣ ����
				}
				
				writing.setWriting_id(seqno);//���̹����ۿ� �۹�ȣ ����
				
				int result = crud.insertWrtingInfo(writing);//���ۻ���
				
				result = crud.insertWritingContent(writing);
				
				if(result < 0) throw new ServletException(
						"writing_info ���̺� ���� �� ����");
				
			}
		}catch(Exception e){
			throw new ServletException(e);
		}
		//������ ��ȯ
		response.sendRedirect("image-list");
	}

}



















