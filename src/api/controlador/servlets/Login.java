package api.controlador.servlets;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import api.controlador.htmls;
import api.modelo.PMF;
import api.modelo.tablas.Admin;
import api.modelo.tablas.Cuenta;
import api.modelo.tablas.Persona;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        
        PersistenceManager pm = PMF.get().getPersistenceManager();
        
        try{
        	Admin admin = Admin.getAdmin();
        	if(admin.isCuenta(usu, pass)){
        		sesion.setAttribute("admin", admin);
        		htmls.session_active(admin.getCuenta());
        		response.sendRedirect(htmls.ADMIN_HOME_PAGE);
        	}
        	else{
        		/*
        		 * FALTA IMPLEMENTAR ESTA PARTE PARA ALUMNO Y PROFESOR
        		 * 
        		 */
                Query q = pm.newQuery(Cuenta.class);
                q.setFilter("CUENTA == idl");
                q.declareParameters("String idl");
                List<Cuenta> ids = (List<Cuenta>) q.execute(usu);
        		if(!ids.isEmpty()){
        			Cuenta user = ids.get(0);
            	    if(user.isCuenta(usu, pass) && sesion.getAttribute("usuario") == null){
            	    	sesion.setAttribute("usuario", user);
            	    	htmls.session_active(user.getCuenta());
            	    	response.sendRedirect(htmls.HOME);
            	    }else{
            	    	response.setContentType("text/plain");
            	    	response.getWriter().print("contrase�a incorrecta");
            	    }
            	    
        		}
            	else{
            		response.setContentType("text/plain");
            		response.getWriter().print("IdLogin Incorrecto");
        		}
        	}
        }catch(Exception e){
        	response.sendRedirect(htmls.ERROR_JSP);
        }finally{
        	pm.close();
        }
    }
 
   //método encargado de la gestión del método GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        //me llega la url "proyecto/login/out"
        String action =  request.getRequestURI()!=null?request.getRequestURI():"";
        if(action.equals(htmls.LOGIN)){
        	request.getRequestDispatcher(htmls.LOGIN_JSP).forward(request, response);
        }
        else if(action.equals(htmls.UNLOGIN)){
            HttpSession sesion = request.getSession();
            sesion.invalidate();
            htmls.session_disable();
            response.sendRedirect(htmls.HOME);
        }
        else if(action.equals(htmls.REGISTRER)){
        	request.getRequestDispatcher(htmls.REGISTRAR_JSP).forward(request, response);
        }
        else{
        	response.sendRedirect(htmls.PAGE_NO_FOUND_JSP);
        }
    }
}
