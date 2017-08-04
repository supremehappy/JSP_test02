package bookStore;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudHome;
import model.UserInfo;

/**
 * Servlet Filter implementation class AdminCheckFilter
 */
@WebFilter("/AdminCheckFilter")
public class AdminCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=
				(HttpServletResponse)response;
		HttpSession session = httpRequest.getSession();
		String id = (String)session.getAttribute("ID");
		CrudHome crud = new CrudHome();			
		
		if(id == null){
			httpResponse.sendRedirect("index.jsp?BODY=login.jsp?UPLOAD=fail");
		}else{
			UserInfo info = crud.selectAdmin(id);	
			if(info.getAdmin()==1){
				chain.doFilter(request, response);
			}else{
				httpResponse.sendRedirect("notice-list");
			}	
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}