<%@page import="api.controlador.htmls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Index</title>
	<%=htmls.ESTILOS_1%>
</head>
<body>
	<%=htmls.PORTADA%>
	<div id="contenedor">
	<%=htmls.MENU%>
	<div>
		<%=htmls.MENU_S%>
		<div id="page">
		    <a href=<%=htmls.REGISTRER %>>Registrate</a>
			<form action=login method="post">
			<input type="text" name="user"/>
			<input type="password" name="password"/>
			<input type="submit" value="Ingresar"/>
			
			</form>
		</div>
	</div>
	</div>
	<%=htmls.FOOTER%>
</body>
</html>