package ch15;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrap extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public RequestWrap(HttpServletRequest request) {
		super(request);
		this.request = request; // 외부에서 온 데이터를 바꾼다.
	}

	public String getParameter(String name) {
		String value = request.getParameter(name);
		if (name.equals("name")) {
			return value + " 에이 바보";
		} else {
			return value;
		}
	}

	public String[] getParameterValues(String name) {
		String[] values = request.getParameterValues(name);
		if (values == null || values.equals("")) {
			return null;
		}
		String[] newValue = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			newValue[i] = values[i] + " 맛있어";
		}
		return newValue;
	}
}
