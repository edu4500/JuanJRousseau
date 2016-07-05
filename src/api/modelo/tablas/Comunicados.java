package api.modelo.tablas;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;
@PersistenceCapable
public class Comunicados {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key KEY;
	
	@Persistent
	private Key CURSO;
	
	@Persistent
	private String COMUNICADO;
	
	@Persistent
	private String FECHA;
	//AAAA-MM-DD--HH:MM
	
	public Comunicados(String comunicado,String Fecha){
		this.COMUNICADO = comunicado;
		this.FECHA = Fecha;
	}
	
	public Key getKey(){
		return KEY;
	}
	
	public void setCurso(Curso c){
		this.CURSO = c.getKey();
	}
	
	public Key getCurso(){
		return CURSO;
	}
	
	public void setComunicado(String Comunicado){
		this.COMUNICADO = Comunicado;
	}
	
	public String getComunicado(){
		return COMUNICADO;
	}
	public void setFecha(String fecha){
		this.FECHA = fecha;
	}
	
	public String getFecha(){
		return FECHA;
	}
}
