package api.modelo.tablas;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Cuenta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key KEY;
	
	@Persistent 
	private String CUENTA;
	
	@Persistent 
	private String CONTRASENIA;
	
	@Persistent 
	private Key PERSONA;
	
	public Cuenta(String Cuenta,String Contraceña){
		this.CUENTA = Cuenta;
		this.CONTRASENIA = Contraceña;
	}
	
	public void setKey(Key KEY){this.KEY = KEY;}
	
	public Key getKey(){return KEY;}
	
	public void setCuenta(String newCuenta){CUENTA = newCuenta;}
	
	public String getCuenta(){return CUENTA;}
	
	public void setContrasenia(String newContrasenia){CONTRASENIA = newContrasenia;}
	
	public String getContrasenia(){return CONTRASENIA;}
	
	public void setPersona(Persona p){PERSONA = p.getKey();}
	
	public Key getPersona(){return PERSONA;}
	
	@Override
	public String toString() {
		String resp = KEY + " : " +CUENTA + " : " + CONTRASENIA + " : " + PERSONA;  
		return resp;
	}
	public String toStringHTML() {
		String resp = ""
				+"<td>"+KEY+"</td>\n"
				+"<td>"+CUENTA+"</td>\n" 
				+"<td>"+CONTRASENIA+"</td>\n" 
				+"<td>"+PERSONA+"</td>\n";
		return resp;
	}
	
	public boolean isCuenta(String user,String contrasenia){
		return this.CUENTA.equals(user) && this.CONTRASENIA.equals(contrasenia);
	}
	
	public boolean isCuenta(Cuenta c){
		return this.CUENTA.equals(c.CUENTA) && this.CONTRASENIA.equals(c.CONTRASENIA);
	}
}
