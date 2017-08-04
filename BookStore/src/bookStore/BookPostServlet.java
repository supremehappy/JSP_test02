package bookStore;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudHome;
import model.BookItem;

/**
 * Servlet implementation class BookPostServlet
 */
@WebServlet("/book-post")
public class BookPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookPostServlet() {
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
		/*HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");*/
		String book_title = request.getParameter("BOOK_TITLE");
		String writer = request.getParameter("WRITER");
		String company = request.getParameter("COMPANY");
		String price = request.getParameter("PRICE");
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;// 값이 0부터 시작하기 때문에 1을 더해주어야 원하는 값을 얻을 수 있다.
		int day = today.get(Calendar.DATE);
		String reg_date = year + "년 " + month + "월 " + day + "일";
		CrudHome crud = new CrudHome();
		int book_code = crud.selectMaxBookCode();// 도서코드 찾음
		book_code = book_code + 1;
		BookItem bookItem = new BookItem();
		bookItem.setBook_code(book_code);
		bookItem.setBook_title(book_title);
		bookItem.setWriter(writer);
		bookItem.setCompany(company);
		bookItem.setPrice(Integer.parseInt(price));
		bookItem.setReg_date(reg_date);
		int result = crud.insertBook(bookItem);
		if(result < 0) throw new ServletException("도서정보 등록 중 문제 발생!");
		// 글 목록을 보여주는 서블릿을 호출
		response.sendRedirect("book-list");
	}

}
