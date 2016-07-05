<%@page import="api.controlador.htmls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Index</title>
	<%=htmls.ESTILOS_1%>
</head>
<body>
	<%=htmls.PORTADA%>
	<div id="contenedor">
		<%=htmls.MENU %>
		<div>
			<%=htmls.MENU_S%>
			<div id="page">
				<iframe src="https://calendar.google.com/calendar/embed?src=qtng7gaklvi8ens9a4smr4pvdk%40group.calendar.google.com&ctz=America/Lima" style="border: 0" width="660" height="600" frameborder="0" scrolling="no"></iframe>
			</div>
		</div>
	</div>
	<%=htmls.FOOTER%>
</body>
</html>