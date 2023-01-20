<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>오늘의 메뉴</h2>
	<%
	String[] menu = request.getParameterValues("menu");
	if (menu == null) {
		out.print("먹을게 없네");
	} else {
		for (String m : menu) {
			out.println(m + "<br>");
		}
	}
	%>
</body>
</html>