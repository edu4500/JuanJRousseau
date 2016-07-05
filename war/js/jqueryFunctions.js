
$(function() {
	$('#mostrarCode').click(function(event) {
		$.get('/AdminDatos',{
			action : "mostrar"
		},function(responseText) {
			$('#tabla').html(responseText);
		});
	});
});

$(function() {
	$('#generateCode').click(function(event) {
		$.get('/AdminDatos',{
			action : "generar"
		},function(responseText) {
			$('#tabla').html(responseText);
		});
	});
});

$(function() {
	$('#limpiarCode').click(function(event) {
		alert("Hello! I am an alert box!!");
		$.get('/AdminDatos',{
			action : "limpiar"
		},function(responseText) {
			$('#tabla').html(responseText);
		});
	});
});

$(function() {
	$('#crearNuevoCurso').click(function(event) {
		var codigoCurso_VAR = $('#codigoCurso').val();
		var nombreCurso_VAR = $('#nombreCurso').val();
		$.get('/AdminDatos',{
				action : "crearCurso",
				nombreCurso : nombreCurso_VAR
		},function(responseText) {
			$('#tabla').html(responseText);
		});
	});
});

$(function(){
	$('.modCurso').click(function(){
		var cod = $(this).parent().siblings().first().text();
		var nomCur = $(this).parent().siblings().eq(1).children().val();
		$.get('/AdminDatos',{
			action : "modCurso",
			codCurso : cod,
			nomCurso : nomCur
		},function(responseText) {
			$('#tabla').html(responseText);
		});
	});
});
$(function(){
	$('.borCurso').click(function(){
		var cod = $(this).parent().siblings().first().text();
		$.get('/AdminDatos',{
			action : "borCurso",
			codCurso : cod
		},function(responseText) {
			$('#tabla').html(responseText);
		});
		
	});
});

$(function(){
    $('#crearc').click(function(){
	   $(this).next('#crear-curso-content').slideToggle();
	   $(this).toggleClass('active');          
	   });
	});

$(document).ready(function() {
	$('.slideshow').cycle({
		fx: 'scrollRight' // choose your transition type, ex: fade, scrollUp, shuffle, etc...
	});
});

