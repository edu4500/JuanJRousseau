package api.controlador;

public class htmls {
	
	//servlet direcciones
	public static final String HOME = "/index.jsp";
	public static final String INSTITUCION = "/institución";
	public static final String GALERIA = "/galeria";
	public static final String CONTACTENOS = "/contactenos";
	public static final String LOGIN = "/login";
	public static final String UNLOGIN = "/logn/out";
	public static final String REGISTRER = "/login/registrar";
	public static final String ADMIN_HOME_PAGE = "/admin/adminHomePage";
	public static final String ADMIN_ADMI_CURSO = "/admin/adminCursos";
	
	//imagenes direcciones
	public static final String LOGO_IMG = "/images/logo.jpg";
	public static final String IMG_1 = "/images/imgc1.jpg";
	public static final String IMG_2 = "/images/imgc2.jpg";
	public static final String IMG_3 = "/images/imgc3.jpg";
	
	//jsp 
	public static final String REGISTRAR_JSP = "/registrar.jsp";
	public static final String PAGE_DENNY_JSP = "/paginaNoAutorisada.jsp";
	public static final String PAGE_NO_FOUND_JSP = "/paginaNoEncontrada.jsp";
	public static final String LOGIN_JSP = "/login.jsp";
	public static final String ERROR_JSP = "/error.jsp";

	//js direcciones
	public static final String JQUERY_JS = "/js/jquery.js";
	public static final String CYCLE_JS = "/js/cycle.js";
	public static final String JQUERYFUNCTIONS_JS = "/js/jqueryFunctions.js";
	public static final String JQUERY_LATEST_JS = "/js/jquery-latest.js";
	
	//hoja de estilos
	public static final String STYLE = "/estilos/style.css";
	
	//html
	public static final String HEAD = "<head>\n";
	public static final String LHEAD = "</head>\n";
	public static final String BODY = "<body>\n";
	public static final String LBODY = "</body>\n";
	public static final String HTML = "<html>\n";
	public static final String LHTML = "</html>\n";
	public static final String TABLE = "<table>\n";
	public static final String LTABLE = "</table>\n";
	public static final String TR = "<tr>";
	public static final String LTR = "</tr>";
	public static final String TD = "<td>";
	public static final String LTD = "</td>";
	public static final String BR = "<br>";
	public static final String A = "<a>";
	public static final String LA = "</a>";
	
	public static final String ESTILOS_1 = "<link href=\""+STYLE+"\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n";
	public static final String DINAMISMO_FOTOS = ""
			+"<script type=\"text/javascript\" src="+JQUERY_JS+"></script>\n"
			+"<script type=\"text/javascript\" src="+CYCLE_JS+"></script>\n"
			+"<script type=\"text/javascript\" src="+JQUERYFUNCTIONS_JS+"></script>\n";
	public static final String PORTADA = ""
			+"<div id=\"wrapper\">\n"
			+"	<div id=\"header\">\n"
			+"		<h1>Juan Jacobo Rousseau</h1>\n"
			+"		<img src="+LOGO_IMG+" width=\"100%\" height=\"150\">\n"
			+"		<h2>TRABAJANDO UNIDOS POR UNA EDUCACIÓN CONSCIENTE</h2>\n"
			+"	</div>\n"
			+"</div>\n";
	private static String li_login_dinamico = "		<li><a href="+LOGIN+">Login</a></li>\n";
	public static String MENU = ""
			+"<div id=\"menu\">\n"
			+"	<ul>\n"
			+"		<li class=\"current_page_item\"><a href="+HOME+">Inicio</a></li>\n"
			+"		<li><a href="+INSTITUCION+">Nuestra Instituci&oacute;n</a></li>\n"
			+"		<li><a href="+GALERIA+">Galeria</a></li>\n"
			+"		<li><a href="+CONTACTENOS+">Contacto</a></li>\n"
			+li_login_dinamico
			+"	</ul>\n"
			+"</div>\n";
	public static final String SLIDESHOW = ""
			+"<div class=\"slideshow\">\n"
			+"	<img src="+IMG_1+" width=\"910\" height=\"300\">\n"
			+"	<img src="+IMG_2+" width=\"910\" height=\"300\">\n"
			+"	<img src="+IMG_3+" width=\"910\" height=\"300\">\n"
			+"</div>\n";
	public static final String MENU_S = ""
			+"<div id=\"menu_s\">\n"
			+"	<ul>\n"
			+"		<li><a href=\"#\">Inicial</a></li>\n"
			+"		<li><a href=\"#\">Primaria</a></li>\n"
			+"		<li><a href=\"#\">Secundaria</a></li>\n"
			+"		<li><a href=\"#\">Calendario Escolar</a></li>\n"
			+"	</ul>\n"
			+"</div>\n";
	public static final String FOOTER = ""
			+"<div id=\"footer\">\n"
			+"	<div class=\"fleft\"><p>Copyright statement.</p></div>\n"
			+"	<div class=\"fright\"><p>Diseñado por: Dewitt Chavez, Henry Talavera, Milagros Mayta, Eduardo Sutta</p></div>\n"
			+"	<div class=\"fclear\"></div>\n"
			+"</div>\n";
	public static final String MENU_ADMIN = ""
			+"<div id=\"menu_admin\">\n"
			+"	<ul>\n"
			+"		<li><a href="+ADMIN_HOME_PAGE+">CRUD generar id</a></li>\n"
			+"		<li><a href="+ADMIN_ADMI_CURSO+">CRUD cursos</a></li>\n"
			+"		<li><a>CRUD usuarios</a></li>\n"
			+"		<li><a>Matricular alumnos</a></li>\n"
			+"		<li><a>Asignar curcos profesor</a></li>\n"
			+"		<li><a>CRUD eventos calendario</a></li>\n"
			+"		<li><a>Eliminar cuentas</a></li>\n"
			+"		<li><a>CRUD contactenos</a></li>\n"
			+"	</ul>\n"
			+"</div>\n";
	
	public static String HEAD_ADMIN = ""
			+HEAD
			+"<title>Administrador</title>\n"
			+"<script src="+JQUERY_LATEST_JS+"></script>\n"
			+"<script type=\"text/javascript\" src="+JQUERYFUNCTIONS_JS+"></script>\n"
			+LHEAD;
	
	public static void session_active(){
		li_login_dinamico = "		<li><a href="+UNLOGIN+">unLogin</a></li>\n";
	}
	public static void session_disable(){
		li_login_dinamico = "		<li><a href="+LOGIN+">Login</a></li>\n";
	}
	public static void session_active(String user){
		li_login_dinamico = "		<li><a href="+UNLOGIN+">unLogin("+user+")</a></li>\n";
	}
	public static String msj_alerta(String msj){
		return "<script>console.log(alert(\""+msj+"\"));</script>";
	}

}
