package myhome;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudHome;
import model.BBSItem;
import model.IdSequence;
import model.ProItem;

/**
 * Servlet implementation class ProductPostServlet
 */
@WebServlet("/pro-post")
public class ProductPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPostServlet() {
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
		
		CrudHome crud = new CrudHome();
		ProItem pro = new ProItem();
		
		HttpSession session=request.getSession();
		
		//--------------------------------------------------
		String id = (String)session.getAttribute("ID");
		String name = request.getParameter("PRONAME");
		int price = Integer.parseInt(request.getParameter("PROPRICE"));
		String content = request.getParameter("CONTENT");
		String pwd=request.getParameter("password");
		//--------------------------------------------------
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int day = today.get(Calendar.DATE);
		String proDate = year+"년 "+month+"월 "+day+"일 ";
		//--------------------------------------------------
		String parentId = request.getParameter("parentid");
		String groupId = request.getParameter("groupid");
		String orderNo = request.getParameter("orderno");
		
		if((parentId==null)||(parentId.equals(""))){ // 원글
			pro.setParent_id(0);
			pro.setOrder_no(0);
			pro.setGroup_id(crud.selectMaxGroupId()+1);
			
		}else{ // 답글
			pro.setParent_id(Integer.parseInt(parentId));
			pro.setGroup_id(Integer.parseInt(groupId));
			pro.setOrder_no(Integer.parseInt(orderNo));
			
			crud.updateOrderNo(pro);
		}
		//--------------------------------------------------
		
		pro.setName(name);
		pro.setPrice(price);
		pro.setP_date(proDate);
		pro.setPassword(pwd);
		pro.setContent(content);
		pro.setId(id);
		
		//--------------------------------------------------
	
		int pid = crud.selectLastId("product_info");
		
		pid = pid + 1;
		
		IdSequence seq = new IdSequence();
		
		seq.setLast_id(pid);
		seq.setName("product_info");
		
		if(pid == 1){
			crud.insertLastId(seq);//���ο� �۹�ȣ ����
		} else {
			crud.updateLastId(seq);//�۹�ȣ ����
		}
		
		pro.setPid(pid);//���̹����ۿ� �۹�ȣ ����
		
		int result = crud.insertProInfo(pro);//���ۻ���
		
		result = crud.insertProContent(pro);
		
		if(result <0) throw new ServletException("upload error");
		
		
		response.sendRedirect("pro-list");
	}
}
