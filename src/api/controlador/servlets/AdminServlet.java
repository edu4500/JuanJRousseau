package api.controlador.
servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import api.controlador.htmls;
import api.modelo.PMF;
import api.modelo.tablas.Admin;
import api.modelo.tablas.Cuenta;
import api.modelo.tablas.Curso;

@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession sesion = req.getSession();
		Admin admin = (Admin) sesion.getAttribute("admin");
        String action =  req.getRequestURI()!=null?req.getRequestURI():"";
		if(action.equals(htmls.ADMIN_HOME_PAGE)){
			if(admin!=null){
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println(""
						+htmls.HTML
						+htmls.HEAD_ADMIN
						+htmls.BODY
						+htmls.MENU_ADMIN
						+"<div id=\"botones\">\n"
        				+"<button id=\"generateCode\">Generar</button>\n"
        				+"<button id=\"limpiarCode\">Limpiar</button>\n"
        				+"<button id=\"mostrarCode\">Ver Codigos</button>\n"
        				+"</div>\n"
        				+"<div id=\"tabla\"></div>\n"
        				+htmls.LBODY
        				+htmls.LHTML
        		);
			}
			else
				resp.sendRedirect(htmls.PAGE_DENNY_JSP);
		}
		else if(action.equals(htmls.ADMIN_ADMI_CURSO)){
			if(admin!=null){
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println(""
						+htmls.HEAD_ADMIN
						+htmls.BODY
						+htmls.MENU_ADMIN
						+"<nav class=\"acceder\">\n"
						+"<a id=\"crearc\" href=\"#\">Crear Curso</a>\n"
						+"	<div id=\"crear-curso-content\">\n"
						+"		<form>\n"
						+"		Curso\n"
						+"		<input id=\"nombreCurso\" type=\"text\" name=\"nombreCurso\" placeholder=\"Nombe del curso\" required>\n"   
						+"		<input type=\"button\" id=\"crearNuevoCurso\" value=\"Crear\">\n"
						+"		</form>\n"
						+"	</div>\n"
						+"</nav>\n"
						+"<div id=\"tabla\">"
						+htmls.TABLE
						+DatoAdminServlet.viewCursos()
						+htmls.LTABLE
						+"</div>"
        				+htmls.LBODY
        		);
			}
			else
				resp.sendRedirect(htmls.PAGE_DENNY_JSP);
		}
		else
			resp.sendRedirect(htmls.PAGE_NO_FOUND_JSP);
	}

}
