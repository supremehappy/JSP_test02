package myHome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private void readBBS(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    	CrudHome crud = new CrudHome();
    	List list = crud.selectBBS();
    	Iterator it = list.iterator();
    	BBSList bbsList = new BBSList();
    	
    	for(int i = 0; i<5 ;i++){
    		if(it.hasNext()){
    			BBSItem item = (BBSItem) it.next();
        		
        		bbsList.setSeqNoList(i, item.getSeqno());
        		bbsList.setTitleList(i, item.getTitle());
        		bbsList.setWriterList(i, item.getId());
        		bbsList.setDateList(i, item.getBbs_date());
    		}else{
    			break;
    		}
    	}
    	
		bbsList.setFirstPage(true);
		
		int pageNum = readPageNum();
		bbsList.setPageNum(pageNum);
		
		request.setAttribute("BBS_LIST", bbsList);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsListView.jsp");
		
		dis.forward(request, response);
    }
    
    private void readNextPage(String lastSeqNo,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	BBSList list = new BBSList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectNextPage(Integer.parseInt(lastSeqNo));
    	Iterator it = result.iterator();
    	
    	for(int i= 0; i<5;i++){
    		if(it.hasNext()){
    			BBSItem item = (BBSItem)it.next();
    			
    			list.setSeqNoList(i, item.getSeqno());
    			list.setTitleList(i, item.getTitle());
    			list.setWriterList(i, item.getTitle());
    			list.setDateList(i, item.getBbs_date());
    		}else{
    			break;
    		}
    	}
    	
    	if(!it.hasNext()) list.setLastPage(true);
    	
    	int pageNum = readPageNum();
		list.setPageNum(pageNum);
    	
    	request.setAttribute("BBS_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsListView.jsp");
		
		dis.forward(request, response);
    }
    
    private void readPrevPage(String firstSeqNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BBSList list = new BBSList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectPrevPage(Integer.parseInt(firstSeqNo));
    	Iterator it = result.iterator();
    	
    	for(int i=0; i<5 ; i++){
    		if(it.hasNext()){
    			BBSItem item = (BBSItem) it.next();
    			
    			list.setSeqNoList(i, item.getSeqno());
				list.setTitleList(i, item.getTitle());
				list.setWriterList(i, item.getId());
				list.setDateList(i, item.getBbs_date());
    		}else{
    			break;
    		}
    	}
    	
    	int cnt = crud.selectPrevCount(Integer.parseInt(firstSeqNo));
    	
    	if((cnt-5)<5) list.setFirstPage(true);
    	
    	int pageNum = readPageNum();
		list.setPageNum(pageNum);
    	
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsListView.jsp");
		
		dis.forward(request, response);
    }
    
    private void readPage(String pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	BBSList list = new BBSList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectBBSPage(Integer.parseInt(pageNo));
    	Iterator it = result.iterator();
    	
    	for(int i = 0 ; i <5  ;i++){
    		if(it.hasNext()){
    			BBSItem item = (BBSItem) it.next();
    			
    			list.setSeqNoList(i, item.getSeqno());
				list.setTitleList(i, item.getTitle());
				list.setWriterList(i, item.getId());
				list.setDateList(i, item.getBbs_date());
    		}else{
    			break;
    		}
    	}
    	
    	if(Integer.parseInt(pageNo)==1) list.setFirstPage(true);
    	
    	int cnt = crud.selectNextCount(Integer.parseInt(pageNo));
    	if(cnt<6) list.setLastPage(true);
    	
    	int pageNum = readPageNum();
		list.setPageNum(pageNum);
    	
		request.setAttribute("BBS_LIST", list);
		RequestDispatcher dis = request.getRequestDispatcher("templat.jsp?BODY=bbsListView.jsp");
		
		dis.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lastSeqNo = request.getParameter("LAST_SEQNO");
		String firstSeqNo = request.getParameter("FIRST_SEQNO");		
		String pageNo = request.getParameter("PAGE_NO");
		
		if(pageNo!=null){
			readPage(pageNo, request, response);
		}else if(lastSeqNo !=null){
			readNextPage(lastSeqNo,request,response);
		}else if(firstSeqNo!=null){
			readPrevPage(firstSeqNo, request, response);
		}else{
			readBBS(request,response);
		}
	}

	private int readPageNum(){
		
		int pageNum=0;
		CrudHome crud = new CrudHome();
		pageNum = crud.selectPage();
		
		return (pageNum+4)/5;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
