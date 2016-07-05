package api.modelo.tablas;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public class Persona {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key KEY;
	
	@Persistent
	private String NOMBRE;
	
	@Persistent
	private String APELLIDOS;
	
	@Persistent
	private String DNI;
	
	@Persistent
	private Key CUENTA;
	
	public Persona(String Nombres, String Apellidos, String dni) {
		super();
		this.NOMBRE = Nombres;
		this.APELLIDOS = Apellidos;
		this.DNI = dni;
	}

	public String getNombres() {
		return NOMBRE;
	}

	public void setNombres(String Nombres) {
		this.NOMBRE = Nombres;
	}

	public String getApellidos() {
		return APELLIDOS;
	}

	public void setApellidos(String Apellidos) {
		this.APELLIDOS = Apellidos;
	}
	
	public String getDni() {
		return DNI;
	}

	public void setDni(String Dni) {
		this.DNI = Dni;
	}
	
	public void setKey(Key KEY) {
		this.KEY = KEY;
	}
	
	public Key getKey() {
		return KEY;
	}

	public void setCuenta(Key cuentaKey) {
		this.CUENTA = cuentaKey;
	}
	
	public void setCuenta(Cuenta c) {
		this.CUENTA = c.getKey();
	}
	
	public Key geCuenta() {
		return CUENTA;
	}
	
	@Override
	public String toString() {
		String resp = KEY + " : " +NOMBRE + " : " + APELLIDOS;  
		return resp;
	}
}
