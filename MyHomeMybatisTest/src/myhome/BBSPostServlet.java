package myhome;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudHome;
import model.BBSItem;
/**
 * Servlet implementation class BBSPostServlet
 */
@WebServlet("/bbs-post")
public class BBSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSPostServlet() {
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
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		String title = request.getParameter("TITLE");
		String content=request.getParameter("CONTENT");
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DATE);
		String bbsDate = year+"년 "+month+"월 "+day+"일";
		
		CrudHome crud = new CrudHome();
		int seqno = crud.selectMaxSeqno();//글번호 찾음
		seqno = seqno + 1;
		BBSItem bbs = new BBSItem();
		bbs.setSeqno(seqno); bbs.setTitle(title);
		bbs.setContent(content);bbs.setId(id);
		bbs.setBbs_date(bbsDate);
		int result = crud.insertBBS(bbs);
		if(result < 0) throw new ServletException("글 올리는 도중 문제발생!");
		//글 목록을 보여주는 서블릿을 호출
		response.sendRedirect("bbs-list");
	}

}




















