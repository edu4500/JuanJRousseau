package api.modelo.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.*;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Alumno extends Persona {
	
	@Persistent 
	private List<Key> NOTAS_CURSOS;
	
	public Alumno(String Nombres, String Apellidos, String Dni) {
		super(Nombres, Apellidos, Dni);
		NOTAS_CURSOS = new ArrayList<Key>();
	}
	
	public List<Key> getCursos(){
		return NOTAS_CURSOS;
	}
}
