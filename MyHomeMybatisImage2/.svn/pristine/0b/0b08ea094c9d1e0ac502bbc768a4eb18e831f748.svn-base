package myhome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudHome;
import model.BBSItem;
/**
 * Servlet implementation class BBSListServlet
 */
@WebServlet("/bbs-list")
public class BBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void readBBS(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{//메뉴를 눌렀을 때의 처리
    	CrudHome crud = new CrudHome();
    	List<BBSItem> list = crud.selectBBS();
    	Iterator it = list.iterator();

    	BBSList bbsList = new BBSList();
    	for(int i = 0; i < 5; i++){
    		if(it.hasNext()){
	    		BBSItem item = (BBSItem)it.next();
	    		bbsList.setSeqNoList(i, item.getSeqno());
	    		bbsList.setTitleList(i, item.getTitle());
	    		bbsList.setWriterList(i, item.getId());
	    		bbsList.setDateList(i, item.getBbs_date());
    		}else {
    			break;//데이터가 없으면 반복 중지
    		}
    	}
    		//메뉴를 눌러서 게시판을 출력하는 경우는 항상 처음페이지 이므로, "이전 페이지"링크가 없다.
    	bbsList.setFirstPage(true);
		//페이지번호에 대한 정보를 bbsListView.jsp로 전달한다.
		int pageNum = readPageNum();//페이지 갯수를 찾음
		bbsList.setPageNum(pageNum);
		//화면을 게시글 출력 JSP로 바꾸면서 list를 전달한다.
		request.setAttribute("BBS_LIST", bbsList);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsListView.jsp");
		rd.forward(request, response);
    }
    private void readNextPage(String lastSeqNo, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	BBSList list=new BBSList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectNextPage(Integer.parseInt(lastSeqNo));
    	Iterator it = result.iterator();
    	for(int i=0; i< 5; i++){
    		if(it.hasNext()){
    			BBSItem item=(BBSItem)it.next();
    			list.setSeqNoList(i, item.getSeqno());
    			list.setTitleList(i, item.getTitle());
    			list.setWriterList(i, item.getId());
    			list.setDateList(i, item.getBbs_date());
    		}else{
    			break;
    		}
    	}
    	if( ! it.hasNext()) list.setLastPage(true); 
		int pageNum = readPageNum();//페이지 갯수를 찾음
		list.setPageNum(pageNum);

		request.setAttribute("BBS_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsListView.jsp");
		rd.forward(request, response);
    }
    private void readPrevPage(String firstSeqNo, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	BBSList list = new BBSList(); 
    	CrudHome crud = new CrudHome();
    	List result = crud.selectPrevPage(Integer.parseInt(firstSeqNo));
    	Iterator it = result.iterator();
    	for(int i=0; i<5; i++){
    		if(it.hasNext()){
    			BBSItem item = (BBSItem)it.next();
    			list.setSeqNoList(i, item.getSeqno());
    			list.setTitleList(i, item.getTitle());
    			list.setWriterList(i, item.getId());
    			list.setDateList(i, item.getBbs_date());
    		}else{
    			break;
    		}
    	}
    	//이전페이지의 글 갯수가 5개 보다 작으면 이전페이지가 첫번째 페이지
    	int cnt = crud.selectPrevCount(Integer.parseInt(firstSeqNo));
    	if((cnt-5)<5) list.setFirstPage(true);
		int pageNum = readPageNum();//페이지 갯수를 찾음
		list.setPageNum(pageNum);
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsListView.jsp");
		rd.forward(request, response);
    }
    private void readPage(String pageNo, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	BBSList list = new BBSList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectBBSPage(Integer.parseInt(pageNo));
    	Iterator it = result.iterator();
    	for(int i=0; i< 5; i++){
    		if(it.hasNext()){
    			BBSItem item = (BBSItem)it.next();
    			list.setSeqNoList(i, item.getSeqno());
    			list.setTitleList(i, item.getTitle());
    			list.setWriterList(i, item.getId());
    			list.setDateList(i, item.getBbs_date());
    		}else{
    			break;
    		}
    	}
    	if(Integer.parseInt(pageNo)== 1) list.setFirstPage(true);
    	//페이지 이동 후 남은 글의 갯수가 6보다 작으면 현재 페이지는 마지막 페이지
    	int cnt = crud.selectNextCount(Integer.parseInt(pageNo));
    	if( cnt < 6) list.setLastPage(true);
    	
		int pageNum = readPageNum();//페이지 갯수를 찾음
		list.setPageNum(pageNum);

		request.setAttribute("BBS_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsListView.jsp");
		rd.forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstSeqNo = request.getParameter("FIRST_SEQNO");
		String lastSeqNo = request.getParameter("LAST_SEQNO");
		String pageNo = request.getParameter("PAGE_NO");
		if(pageNo != null){
			readPage(pageNo, request, response);
		}else if(lastSeqNo != null){//다음 페이지 링크를 누른경우
			readNextPage(lastSeqNo, request, response);
		}else if(firstSeqNo != null){//이전 페이지 링크를 누른경우
			readPrevPage(firstSeqNo, request, response);
		}else{//게시판 보기 메뉴를 누른 경우
			readBBS(request, response);
		}
	}
	private int readPageNum(){//페이지 갯수를 리턴 메서드
		int pageNum = 0; Connection con=null;Statement stmt=null;
		CrudHome crud = new CrudHome();
		pageNum = crud.selectPage();
		return (pageNum+4) / 5;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}









