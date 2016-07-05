package api.controlador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.modelo.PMF;
import api.modelo.tablas.Persona;

@SuppressWarnings("serial")
public class GetList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(Persona.class);
		
		
		try{
			List<Persona> personas = (List<Persona>) q.execute();
			
			out.println("<ul>");
			for(Persona p: personas){
				out.print("<li>");
				out.println(p);
			}
			out.println("</ul>");
			
			
		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		
	}
}