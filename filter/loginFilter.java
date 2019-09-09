package filter;

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

import Dao.LoginDao;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/Home")
public class loginFilter implements Filter {

    public loginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request1 = (HttpServletRequest) request;
	    HttpServletResponse response1 = (HttpServletResponse) response;
		
		HttpSession session=request1.getSession();  
		String email=(String)session.getAttribute("email"); 
		String password=(String)session.getAttribute("email"); 
		
		System.out.println("email: " + email);
		System.out.println("password: " + password);
		
		System.out.println("email in filter:  " + email);
		
		if (LoginDao.isValid(email, password)) {
			
			System.out.println("inside filter ...");
		           chain.doFilter(request1, response1);
		       } 
		     else {
		           response1.sendRedirect("Login.jsp");
		       }
		 }

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
