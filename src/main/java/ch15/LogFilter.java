package ch15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/sub3/*")
public class LogFilter implements Filter {
	private PrintWriter pw; // 전역변수, 여러 메서드에서 같이 사용
	public void destroy() { //WAS가 종료할 때 실행
		if (pw != null) {
			pw.close();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		GregorianCalendar gc =new GregorianCalendar();
		String date = String.format("%TF %TT", gc,gc);
		pw.write(date+" : sub3 웹 프로그램 실행\r\n");
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {//먼저 실행
		try {
			pw = new PrintWriter("c:/jsp/filLog.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
