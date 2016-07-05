package api.controlador.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import api.controlador.htmls;
import api.modelo.PMF;
import api.modelo.tablas.Admin;
import api.modelo.tablas.Cuenta;
import api.modelo.tablas.Curso;
import api.modelo.tablas.Persona;

@SuppressWarnings("serial")
public class DatoAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		HttpSession sesion = req.getSession();
		Admin admin = (Admin) sesion.getAttribute("admin");
		if(admin==null) {
			resp.sendRedirect(htmls.PAGE_DENNY_JSP);
			return;
		}
	//*/	
		resp.setContentType( "text/html" );
		String action = req.getParameter("action");
		PrintWriter out = resp.getWriter();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		out.print(htmls.TABLE);
		if(action.equals("generar")){
			pm.currentTransaction().begin();
				Cuenta cu = new Cuenta("nuevo",new Date().toString());
				pm.makePersistent(cu);
			pm.currentTransaction().commit();
			
			out.print(viewCodigos());
		}
		else if(action.equals("limpiar")){
			clearCodigos();
			out.print("<a>datos limpiados</a><br>");
		}
		else if(action.equals("mostrar")){
			out.print(viewCodigos());
		}
		else if(action.equals("crearCurso")){
			String nCurso = req.getParameter("nombreCurso");
			Query q = pm.newQuery(Curso.class);
			q.setFilter("NOMBRE_CURSO == paranNombre");
			q.declareParameters("String paranNombre");
			List<Curso> cursos = (List<Curso>) q.execute(nCurso);
			if(cursos.isEmpty()){
				Curso c = new Curso(nCurso);
				pm.makePersistent(c);
			}else{
				out.println(htmls.msj_alerta("CUSRO REPETIDO"));
			}
			out.println(viewCursos());
		}
		else if(action.equals("modCurso")){
			String codCurso = req.getParameter("codCurso");
			String nomCurso = req.getParameter("nomCurso");
			Long ll = Long.parseLong(codCurso);
			Key key = KeyFactory.createKey(Curso.class.getSimpleName(),ll);
			Curso c = pm.getObjectById(Curso.class,key);
			c.setNombres(nomCurso);
			pm.makePersistent(c);
			out.println(viewCursos());
			out.println(htmls.msj_alerta("CUSRO MODIFICADO"));
		}
		else if(action.equals("borCurso")){
			String codCurso = req.getParameter("codCurso");
			Long ll = Long.parseLong(codCurso);
			Key key = KeyFactory.createKey(Curso.class.getSimpleName(),ll);
			Curso c = pm.getObjectById(Curso.class,key);
			pm.deletePersistent(c);
			out.println(viewCursos());
		}
		out.print(htmls.LTABLE);
	}
	
	public static String viewCodigos(){
		String resp = "";
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Cuenta.class);
		q.setFilter("CUENTA == 'nuevo'");
		List<Cuenta> cuentas = (List<Cuenta>) q.execute();
		for(Cuenta c:cuentas)
			resp += htmls.TR+c.toStringHTML()+htmls.LTR;
		return resp;
	}
	public static void clearCodigos(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Cuenta.class);
		q.setFilter("CUENTA == 'nuevo'");
		List<Cuenta> cuentas = (List<Cuenta>) q.execute();
		pm.deletePersistentAll(cuentas);
	}	
	public static String viewCursos(){
		String resp = "";
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Curso.class);
		List<Curso> cursos = (List<Curso>) q.execute();
		for(Curso c:cursos)
			resp += ""
			+htmls.TR+"\n"
			+"<td>"+c.getKey().getId()+"</td>"
			+"<td>  <input type=\"text\" value=\""+c.getNombres()+"\" ></td>"
			+"<td><a class=\"modCurso\" href=\"#\">modificar</a></td>\n"
			+"<td><a class=\"borCurso\" href=\"#\">borrar</a></td>\n"
			+htmls.LTR+"\n";
		return resp;
	}
}
