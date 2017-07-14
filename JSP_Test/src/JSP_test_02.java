

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSP_test_02
 */
@WebServlet("/JSP_test_02")
public class JSP_test_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSP_test_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		
		String name = request.getParameter("name"); 
		int jumin = Integer.parseInt(request.getParameter("jumin"));
		int jumin2 = Integer.parseInt(request.getParameter("jumin"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String mail = request.getParameter("mail");
		String mail2 = request.getParameter("mail2");
		String mail3 = request.getParameter("mail3");
		String post = request.getParameter("post");
		String addr = request.getParameter("addr");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String chk_mail = request.getParameter("chk_mail");
		String items[] = request.getParameterValues("item");
		
		out.print("<html><body>");
		out.println("입력정보<br>");
		out.println("이름 : ");
		out.println(name);
		out.println("<br>주민 : ");
		out.println(jumin+"-"+jumin2);
		out.println("<br>아디 : ");
		out.println(id);
		out.println("<br>비번 : ");
		out.println(pw);
		out.println("<br>비번확인 : ");
		out.println(pw2);
		out.println("<br>이메일 : ");
		out.println(mail+"@"+mail3);
		out.println("<br>우편번호 : ");
		out.println(post);
		out.println("<br>주소 : ");
		out.println(addr+" "+addr2);
		out.println("<br>폰번 : ");
		out.println(phone);
		out.println("<br>직업 : ");
		out.println(job);
		out.println("<br>메일수신 : ");
		out.println(chk_mail);
		out.println("<br>관심분야 : ");
		if(items==null){
			out.println("empty");
		}else{
			for(String item : items){
				out.print(item+" ");
			}
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

