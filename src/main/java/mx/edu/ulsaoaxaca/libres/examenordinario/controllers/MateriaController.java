package mx.edu.ulsaoaxaca.libres.examenordinario.controllers;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.libres.examenordinario.mappers.MateriaMapper;
import mx.edu.ulsaoaxaca.libres.examenordinario.models.Materia;

@RequestMapping("/materia")
@RestController
public class MateriaController {
	
	@Autowired
	MateriaMapper materiaMapper;
	
	@GetMapping("/todas")
	public List<Materia> todas()
	{
		return materiaMapper.findAll();
	}
	
	
	@PostMapping("/nueva")
	public List<Materia> nueva(@RequestParam("nombre") String nombre)
	{
		materiaMapper.create(nombre);
		return materiaMapper.findAll();
	}
	
	@PostMapping("/create")
	public void create(@RequestParam("data") String data)
	{
		String preguntas[] = data.split("\n");
		if (preguntas.length >0) {
			for (int i = 0; i < preguntas.length; i++) {
				String [] parametros = preguntas[i].split("¬");
				String pregunta = parametros[0];
				String respuestas = parametros[1];
				String indice = parametros[2];
				String materia_id = parametros[3];
				materiaMapper.insert(pregunta, respuestas, Integer.valueOf(indice), Integer.valueOf(materia_id));
				
				
			}
		}
		
	}
	
	@GetMapping("/verPreguntas")
	public List<> verPreguntas(@RequestParam("id_materia") String id_materia)
	{
		
	}
}
