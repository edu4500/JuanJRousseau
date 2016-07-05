package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;


import api.modelo.PMF;
import api.modelo.tablas.Admin;
import api.modelo.tablas.Cuenta;

@SuppressWarnings("serial")
public class JuanJRousseauServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	

		resp.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = resp.getWriter();

		// Obtengo los datos de la peticion
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String edad = req.getParameter("edad");
		
		out.print(nombre+"<br>");
		out.print(apellido+"<br>");
		out.print(edad+"<br>");
		
		
		/*	PersistenceManager pm = PMF.get().getPersistenceManager();
		Cuenta cj = new Cuenta("jw4ww","EWEW");
		pm.makePersistent(cj);
		System.out.println("---------------------------");
		
		Query q = pm.newQuery(Cuenta.class);
		List<Cuenta> cuentas = (List<Cuenta>) q.execute();
	//	pm.deletePersistentAll(cuentas);
		for(Cuenta c:cuentas)
			System.out.println(c);
		
		System.out.println("---------------------------");
		Query q2 = pm.newQuery(Cuenta.class);
		q2.setFilter("CUENTA == 'nuevo'");
		cuentas = (List<Cuenta>) q2.execute();
		for(Cuenta c:cuentas)
			System.out.println(c);
*/
	}
}
