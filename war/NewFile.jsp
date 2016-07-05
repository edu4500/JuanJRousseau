<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(function(){
		       $('#crearc').click(function(){
			   $(this).next('#crear-curso-content').slideToggle();
			   $(this).toggleClass('active');          
			   });
			});
			$(function(){
				$('.dato').click(function(){
					alert( $(this).parent().siblings().eq(1).children().val() );
				});
			});
			
			
		</script>
</head>
<body>
	<table>
		<tr>
			<td>Curso(5189694883102720)</td>
			<td> <input type="text" value="Fisica 1"/></td>
			<td><a class="dato" href="#">modificar</a></td>
			<td><a href=>borrar</a></td>
		</tr>
		<tr>
		<script>console.log(alert("elementos repetidos"));</script>
			<td>Curso(6315594789945344)</td>
			<td>Fisica 2</td>
			<td><a class="dato" href="#">modificar</a></td>
			<td><a href=>borrar</a></td>
		</tr>
	</table>
</body>
</body>
</html>