package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServelt
 */
@WebServlet("/hello")
public class HelloServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에게 응답할 페이지 정보를 셋팅한다.
		response.setContentType("text/html");
		// [Ctrl+Shift+오우(알파벳)] : 자동 import
		PrintWriter out=response.getWriter();
		out.print("<html><body><h1>");
		out.print("Hello Servlet");
		out.print("</h1></body></html>");
		out.close();
	}

}
