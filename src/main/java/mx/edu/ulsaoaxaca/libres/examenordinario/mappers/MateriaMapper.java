package mx.edu.ulsaoaxaca.libres.examenordinario.mappers;

import java.sql.Clob;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mx.edu.ulsaoaxaca.libres.examenordinario.models.Materia;
import mx.edu.ulsaoaxaca.libres.examenordinario.models.Pregunta;

@Mapper
public interface MateriaMapper {
	
	@Select("Select id, nombre From materia")
	public List<Materia> findAll();
	
	@Insert("Insert into materia(nombre) values(#{nombre})")
	public void create(@Param("nombre") String nombre);
	
	@Insert("Insert into materia_preguntas(pregunta, respuestas, indice, materia_id) values(#{pregunta},#{respuestas},#{indice},#{materia_id})")
	public void  insert (@Param("pregunta") String pregunta,@Param("respuestas") String respuestas, @Param("indice") Integer indice, @Param("materia_id") Integer materia_id );

	@Select("Select id, pregunta, respuestas, indice from materia_preguntas where materia_id=#{id_materia} ORDER BY RAND() LIMIT 2 ")
	public List<Pregunta> findPreguntas(@Param("id_materia") String id_materia);
	
	@Delete("Delete from materia_preguntas Where pregunta = #{pregunta}")
	public void deletePregunta(@Param("pregunta") String pregunta);
	
	@Select("Select id, pregunta, respuestas, indice from materia_preguntas Where respuestas Like '%'||#{respuesta}||'%'  ")
	public List<Pregunta> findResp(@Param("respuesta") String respuesta);
	
	@Update("Update materia_preguntas Set respuestas = #{respuestas} Where id=#{id}")
	public void updateR(@Param("respuestas") String respuestas, @Param("id") String id);
}
