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
			<form action="">
				<a>Contactenos<a><br>
				Nombres y Apellidos *<br>
				<input type="text"><br>
				Correo Electronico *<br>
				<input type="text"><br>
				Consulta *<br>
				<textarea rows="3" cols="31"></textarea><br>
				<input type="submit" value="enviar">
			</form>		
		</div>
	</div>
	</div>
	<%=htmls.FOOTER%>
</body>
</html>