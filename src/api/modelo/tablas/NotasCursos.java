package api.modelo.tablas;

import javax.jdo.annotations.*;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class NotasCursos {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key KEY;
	
	@Persistent
	private short MATRICULA;
	
	@Persistent
	private Key CURSO;
	
	@Persistent
	private Key ALUMNO;
	
	@Persistent
	private int [] NOTAS;
	
	public NotasCursos(){
		NOTAS = new int[4];
	}
	
	public void setKey(Key KEY){this.KEY = KEY;}
	
	public Key getKey(){return KEY;}
	
	public void setMatricula(short Matricula){this.MATRICULA = Matricula;}
	
	public short getMatricula(){return MATRICULA;}
	
	public void setCurso(Curso c){this.CURSO = c.getKey();}
	
	public Key getCurso(){return CURSO;}
	
	public void setAlumno(Alumno a){this.ALUMNO = a.getKey();}
	
	public Key getALumno(){return ALUMNO;}
	
	public void setNota1(int n){this.NOTAS[1] = n;}
	public void setNota2(int n){this.NOTAS[2] = n;}
	public void setNota3(int n){this.NOTAS[3] = n;}
	public void setNota4(int n){this.NOTAS[4] = n;}
	
	public int[] getNotas(){return NOTAS;}
}
