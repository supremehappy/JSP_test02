package bookStore;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudHome;
import model.BookItem;
import model.BookList;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/book-list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void readBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// 메뉴를 눌렀을때의 처리
    	CrudHome crud = new CrudHome();
    	List<BookItem> list = crud.selectBook();
    	Iterator it = list.iterator();
    	BookList bookList = new BookList();
    	for(int i=0; i<5; i++) {
    		if(it.hasNext()) {
    			BookItem item = (BookItem) it.next();
    			bookList.setBookCodeList(i, item.getBook_code());
    			bookList.setBookTitleList(i, item.getBook_title());
    			bookList.setWriterList(i, item.getWriter());
    			bookList.setCompanyList(i, item.getCompany());
    			bookList.setPriceList(i, item.getPrice());
    			bookList.setRegDateList(i, item.getReg_date());
    		} else {
    			break;// 데이터가 없으면 반복 중지
    		}
    	}
    	// 메뉴를 눌러 게시판을 출력하는 경우는 항상 처음 페이지 이므로, "이전 페이지" 링크가 없다.
		bookList.setFirstPage(true);
		// 페이지 번호에 대한 정보를 bbsListView.jsp로 전달한다.
		int pageNum = readPageNum();// 페이지 갯수를 찾음
		bookList.setPageNum(pageNum);
		// 페이지 갯수를 찾아야 한다.
		// 화면을 게시글 출력 JSP로 바꾸면서 list를 전달한다.
		request.setAttribute("BOOK_LIST", bookList);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?BODY=bookListView.jsp");
		rd.forward(request, response);
    }// end readBook()
    private void readNextPage(String lastBookCode, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{// 다음 페이지 링크를 누른 경우
    	BookList list = new BookList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectNextPage(Integer.parseInt(lastBookCode));
    	Iterator it = result.iterator();
    	for(int i=0; i<5; i++) {
    		if(it.hasNext()) {
    			BookItem item = (BookItem) it.next();
    			list.setBookCodeList(i, item.getBook_code());
    			list.setBookTitleList(i, item.getBook_title());
    			list.setWriterList(i, item.getWriter());
    			list.setCompanyList(i, item.getCompany());
    			list.setPriceList(i, item.getPrice());
    			list.setRegDateList(i, item.getReg_date());
    		} else {
    			break;
    		}
    	}
    	if(!it.hasNext()) list.setLastPage(true);
    	int pageNum = readPageNum();
    	list.setPageNum(pageNum);
    	request.setAttribute("BOOK_LIST", list);
    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp?BODY=bookListView.jsp");
    	rd.forward(request, response);
    }// end readNextPage()
    private void readPrevPage(String firstBookCode, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{// 이전 페이지 링크를 누른 경우
    	BookList list = new BookList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectPrevPage(Integer.parseInt(firstBookCode));
    	Iterator it = result.iterator();
    	for(int i=0; i<5; i++) {
    		if(it.hasNext()) {
    			BookItem item = (BookItem) it.next();
    			list.setBookCodeList(i, item.getBook_code());
    			list.setBookTitleList(i, item.getBook_title());
    			list.setWriterList(i, item.getWriter());
    			list.setCompanyList(i, item.getCompany());
    			list.setPriceList(i, item.getPrice());
    			list.setRegDateList(i, item.getReg_date());
    		} else {
    			break;
    		}
    	}
    	// 이전 페이지의 글 갯수가 5개 보다 작으면 이전페이지가 첫번째 페이지 
    	int cnt = crud.selectPrevCount(Integer.parseInt(firstBookCode));
    	if((cnt-5)<5) list.setFirstPage(true);
    	int pageNum = readPageNum();// 페이지 갯수를 찾음
		list.setPageNum(pageNum);
    	request.setAttribute("BOOK_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?BODY=bookListView.jsp");
		rd.forward(request, response);
    }// end readPrevPage()
    private void readPage(String pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BookList list = new BookList();
    	CrudHome crud = new CrudHome();
    	List result = crud.selectPage(Integer.parseInt(pageNo));
    	Iterator it = result.iterator();
    	for(int i=0; i<5; i++) {
    		if(it.hasNext()) {
	    		BookItem item = (BookItem) it.next();
				list.setBookCodeList(i, item.getBook_code());
				list.setBookTitleList(i, item.getBook_title());
				list.setWriterList(i, item.getWriter());
				list.setCompanyList(i, item.getCompany());
				list.setPriceList(i, item.getPrice());
				list.setRegDateList(i, item.getReg_date());
			} else {
				break;
			}
    	}
    	if(Integer.parseInt(pageNo) == 1) list.setFirstPage(true);
    	// 페이지 이동 후 남은 글의 갯수가 6보다 작으면 현재 페이지는 마지막 페이지
    	int cnt = crud.selectNextCount(Integer.parseInt(pageNo));
    	if(cnt<6) list.setLastPage(true);
    	
    	int pageNum = readPageNum();// 페이지 갯수를 찾음
		list.setPageNum(pageNum);
		
    	request.setAttribute("BOOK_LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"index.jsp?BODY=bookListView.jsp");
		rd.forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstBookCode = request.getParameter("FIRST_BOOKCODE");
		String lastBookCode = request.getParameter("LAST_BOOKCODE");
		String pageNo = request.getParameter("PAGE_NO");
		if(pageNo != null) {// 페이지 번호 링크를 누른 경우
			readPage(pageNo, request, response);
		} if(lastBookCode != null) {
			readNextPage(lastBookCode, request, response);
		} else if(firstBookCode != null) {
			readPrevPage(firstBookCode, request, response);
		} else {
			readBook(request, response);
		}
	}// end doGet()
	private int readPageNum() {// 페이지 갯수를 리턴하는 메서드
		int pageNum = 0;
		CrudHome crud = new CrudHome();
		pageNum = crud.selectPage();
		return (pageNum + 4) / 5;
	}// end readPageNum()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
