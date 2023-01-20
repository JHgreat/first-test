package ch15;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrap extends HttpServletResponseWrapper {
	private HttpServletResponse response;
	private StringWriter sw = new StringWriter();
	private PrintWriter pw = new PrintWriter(sw);	//out.println을 변경해서 출력
	//out.println에 사용하기 위해 저장
	public PrintWriter getWriter() {
		return pw;
	}
	public ResponseWrap(HttpServletResponse response) {
		super(response);
		this.response = response; // 외부에서 온 데이터를 바꾼다.
	}
	public void addCookie(Cookie cookie) {
		String value = cookie.getValue();
		String newValue = value +"-보바";
		cookie.setValue(newValue);
		response.addCookie(cookie);
	}
	public void replace() throws IOException{
		String str = sw.toString(); //StringWriter에 있는 문자를 String 형식으로 변경
		String newStr = str.replace("비행기", "강아지");//비행기란 글자를 강아지로 바꿔라
		PrintWriter out = response.getWriter(); //받은 문자를 다시 내보낸다
		out.print(newStr);
	}
	
}
