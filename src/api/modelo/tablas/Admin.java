package api.modelo.tablas;


import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import api.modelo.PMF;

public class Admin extends Cuenta {

	private static Admin ADMIN;
	
	private Admin() {
		super("admin", "admin");
	}
	
	static public Admin getAdmin(){
		if(ADMIN==null)
			ADMIN = new Admin();
		return ADMIN;
	}
	
	public List<Cuenta> generarCodigoUser(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Cuenta nuevo = new Cuenta("nuevo",new Date().toString());
		pm.makePersistent(nuevo);
		Query q = pm.newQuery(Cuenta.class);
		q.setFilter("CUENTA == 'nuevo'");
		return (List<Cuenta>) q.execute();
	}
}
