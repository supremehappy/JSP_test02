package myhome;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CrudHome;
import model.BBSItem;
/**
 * Servlet implementation class BBSItemServlet
 */
@WebServlet("/bbsItem")
public class BBSItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqno=request.getParameter("SEQNO");
		CrudHome crud = new CrudHome();
		BBSItem item = crud.selectBBSItem(Integer.parseInt(seqno));
		request.setAttribute("BBS_ITEM", item);
		RequestDispatcher rd = request.getRequestDispatcher(
				"template.jsp?BODY=bbsContentView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}













