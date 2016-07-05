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
			<%if(request.getAttribute("errores")!=null && request.getAttribute("errores").equals("id")){%>campos con errores<%} %>
		    <form action="registrar" method="post">
			<label for="llave">Numero de validacion</label>
			<input type="text" name="llave"/>
			<br>
			<label for="apellidos">Apellidos</label>
			<input type="text" name="apellidos"/>
			<br>
			<label for="nombres">Nombres</label>
			<input type="text" name="nombres"/>
			<br>
			<label for="dni">DNI</label>
			<input type="text" name="dni"/>
			<br>
			<label for="idlogin">ID </label>
			<input type="text" name="idlogin"/>
			<%if(request.getAttribute("errores")!=null && request.getAttribute("errores").equals("id")){%>*<%} %>
			<br>
			<label for="password">Password</label>
			<input type="text" name="password"/>
			<br>
			<input type="submit" value="Registrar"/>
			
			</form>
		</div>
	</div>
	</div>
	<%=htmls.FOOTER%>
</body>
</html>