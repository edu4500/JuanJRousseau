package api.modelo.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.*;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Profesor extends Persona{

	@Persistent 
	private List<Key> CURSOS;
	
	public Profesor(String Nombres, String Apellidos, String Dni) {
		super(Nombres, Apellidos, Dni);
		CURSOS = new ArrayList<Key>();
	}
	
	public List<Key> getCursos(){
		return CURSOS;
	}
	
	public void addCursos(Curso c){
		CURSOS.add(c.getKey());
	}
}
