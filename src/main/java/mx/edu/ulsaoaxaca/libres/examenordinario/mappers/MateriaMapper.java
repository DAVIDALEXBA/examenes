package mx.edu.ulsaoaxaca.libres.examenordinario.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import mx.edu.ulsaoaxaca.libres.examenordinario.models.Materia;

@Mapper
public interface MateriaMapper {
	
	@Select("Select id, nombre From materia")
	public List<Materia> findAll();
	
	@Insert("Insert into materia(nombre) values(#{nombre})")
	public void create(@Param("nombre") String nombre);
	
	@Insert("Insert into materia_preguntas(pregunta, respuestas, indice, materia_id) values(#{pregunta},#{respuestas},#{indice},#{materia_id})")
	public void  insert (@Param("pregunta") String pregunta,@Param("respuestas") String respuestas, @Param("indice") Integer indice, @Param("materia_id") Integer materia_id );
}
