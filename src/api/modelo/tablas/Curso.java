package api.modelo.tablas;

import javax.jdo.annotations.*;

import com.google.appengine.api.datastore.Key;

import java.util.List;

@PersistenceCapable
public class Curso {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key KEY;
	
	@Persistent
	private String NOMBRE_CURSO;
	
	@Persistent
	private List<Key> NOTAS_CURSO;
	
	@Persistent
	private Key PROFESOR;
	
	public Curso(String nombre_curso) {
		super();
		this.NOMBRE_CURSO = nombre_curso;
	}
	
	public String getNombres() {
		return NOMBRE_CURSO;
	}

	public void setNombres(String Nombres) {
		this.NOMBRE_CURSO = Nombres;
	}
	
	public void setProfesor(Persona p){
		this.PROFESOR = p.getKey();
	}
	public Key getProfesorKey(){
		return PROFESOR;
	}
	public void setKey(Key KEY) {
		this.KEY = KEY;
	}
	public Key getKey() {
		return KEY;
	}
	
	public String toStringHTML() {
		String resp = ""
				+"<td>"+KEY.getId()+"</td>\n"
				+"<td>"+NOMBRE_CURSO+"</td>\n"; 
		return resp;
	}
	
	@Override
	public String toString() {
		String resp = KEY + " : " +NOMBRE_CURSO + " : " + PROFESOR;  
		return resp;
	}
}
