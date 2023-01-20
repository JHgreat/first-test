package ch15;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*@WebFilter("/sub1/*") */
@WebFilter(urlPatterns = {"/sub1/*","/sub2/*"}) //둘다 사용가능
public class SubFilter1 implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("sub1 시작");
		chain.doFilter(request, response); //웹실행
		System.out.println("sub1 끝");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
