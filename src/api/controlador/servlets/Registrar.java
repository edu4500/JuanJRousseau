package api.controlador.servlets;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import api.controlador.htmls;
import api.modelo.*;
import api.modelo.tablas.Persona;

@SuppressWarnings("serial")
public class Registrar extends HttpServlet{


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String llave = req.getParameter("llave");
		Long llavelong = Long.parseLong(llave);
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String idlogin = req.getParameter("idlogin");
		String password = req.getParameter("password");
		String dni = req.getParameter("dni");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			
			Query q = pm.newQuery(Persona.class);
			q.setFilter("IdLogin == idl");
			q.declareParameters("String idl");
			List<Persona> ids = (List<Persona>) q.execute(idlogin);
			if(ids.isEmpty()){
				Key key = KeyFactory.createKey(Persona.class.getSimpleName(), llavelong);
				Persona p = pm.getObjectById(Persona.class, key);
				resp.getWriter().println("Datos grabados correctamente ");
				
				HttpSession sesion = req.getSession();
				sesion.setAttribute("usuario", p);
				htmls.session_active();
				resp.sendRedirect("index.jsp");
			}
			else{
				
				req.setAttribute("errores", "id");
				//resp.sendRedirect("registrar.jsp")
				req.getRequestDispatcher("registrar.jsp").forward(req, resp);
				
			}
			
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrio un error, el numero de validacion no existe");
		}finally{
			pm.close();
		}
		 
		
		
		
	
	}
	
	

}
