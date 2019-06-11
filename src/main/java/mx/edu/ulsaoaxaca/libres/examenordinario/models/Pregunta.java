package mx.edu.ulsaoaxaca.libres.examenordinario.models;

import java.sql.Clob;

import javax.websocket.Decoder.Text;

public class Pregunta {

	
	private Integer id;
	private String pregunta;
	private String[] respArray;
	private String respuestas;
	private Integer indice;
	private Integer materia_id;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String[] getRespArray() {
		return respArray;
	}
	public void setRespArray(String[] respArray) {
		this.respArray = respArray;
	}
	public String getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}
	public Integer getIndice() {
		return indice;
	}
	public void setIndice(Integer indice) {
		this.indice = indice;
	}
	public Integer getMateria_id() {
		return materia_id;
	}
	public void setMateria_id(Integer materia_id) {
		this.materia_id = materia_id;
	}
	
	
	
	
}
