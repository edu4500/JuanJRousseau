package api.controlador.servlets;

import java.io.IOException;
import java.util.Objects;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.modelo.PMF;
import api.modelo.tablas.Persona;

@SuppressWarnings("serial")
public class CrearAlumnos extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		int cantidad = Integer.parseInt(req.getParameter("cant"));
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			
			for(int i = 0; i < cantidad; i++){
			/*	
				Persona p = new Persona(req.getParameter("tipo"));
				pm.makePersistent(p);
				p.setValidacion(Objects.toString(p.getCodigo().getId()));
				resp.getWriter().println("Datos grabados correctamente ");
				//*/
			}
			
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrio un error, vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
	}
}
