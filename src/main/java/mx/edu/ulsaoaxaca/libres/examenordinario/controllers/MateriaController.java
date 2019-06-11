package mx.edu.ulsaoaxaca.libres.examenordinario.controllers;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.ulsaoaxaca.libres.examenordinario.mappers.MateriaMapper;
import mx.edu.ulsaoaxaca.libres.examenordinario.models.Evaluador;
import mx.edu.ulsaoaxaca.libres.examenordinario.models.Materia;
import mx.edu.ulsaoaxaca.libres.examenordinario.models.PResp;
import mx.edu.ulsaoaxaca.libres.examenordinario.models.Pregunta;
import mx.edu.ulsaoaxaca.libres.examenordinario.models.Respuesta;

@RequestMapping("/materia")
@RestController
public class MateriaController {

	@Autowired
	MateriaMapper materiaMapper;

	@GetMapping("/todas")
	public List<Materia> todas() {
		return materiaMapper.findAll();
	}

	@PostMapping("/nueva")
	public List<Materia> nueva(@RequestParam("nombre") String nombre) {
		materiaMapper.create(nombre);
		return materiaMapper.findAll();
	}

	@PostMapping("/deletePregunta")
	public void deletePregunta(@RequestParam("pregunta") String pregunta) {
		materiaMapper.deletePregunta(pregunta);
	}

	@PostMapping("/create")
	public void create(@RequestParam("data") String data) {
		String preguntas[] = data.split("\n");
		if (preguntas.length > 0) {
			for (int i = 0; i < preguntas.length; i++) {
				String[] parametros = preguntas[i].split("¬");
				String pregunta = parametros[0];
				String respuestas = parametros[1];
				String indice = parametros[2];
				String materia_id = parametros[3];
				materiaMapper.insert(pregunta, respuestas, Integer.valueOf(indice), Integer.valueOf(materia_id));

			}
		}

	}

	@GetMapping(value = "/verPreguntas/{id_materia}")
	public List<Pregunta> verPreguntas(@PathVariable(value = "id_materia") String id_materia) {
		List<Pregunta> preguntas = materiaMapper.findPreguntas(id_materia);
		for (int i = 0; i < preguntas.size(); i++) {
			System.out.println("Pregunta: " + preguntas.get(i).getId() + " -> " + preguntas.get(i).getPregunta());
			String[] resp = preguntas.get(i).getRespuestas().split("·");
			preguntas.get(i).setRespArray(resp);
			for (int j = 0; j < resp.length; j++) {
				System.out.println("Respuesta [" + j + "]: " + resp[j]);
			}

		}

		return preguntas;

	}

	@GetMapping("/preguntas/{id_materia}")
	public List<PResp> preguntas(@PathVariable(value = "id_materia") String id_materia) {

//		Respuesta r2 = new Respuesta();
//		r2.setDesc("Respuesta 2");
//		r2.setIsTheRightAnswer(false);
//		
//		Respuesta r3 = new Respuesta();
//		r3.setDesc("Respuesta 3");
//		r3.setIsTheRightAnswer(true);
//		
//		Respuesta r4 = new Respuesta();
//		r4.setDesc("Respuesta 4");
//		r4.setIsTheRightAnswer(false);
//		
//		Respuesta r5 = new Respuesta();
//		r5.setDesc("Respuesta 5");
//		r5.setIsTheRightAnswer(false);

//		PResp p1 = new PResp();
//		p1.setResps(new Respuesta[] {r2,r3,r4,r5});
//      p1.setDesc("¿Hoy es jueves?");

//		PResp p2 = new PResp();

		// data.add(p2);
		List<PResp> data = new ArrayList<PResp>();
		Integer n = 0;
		List<Pregunta> preguntas = materiaMapper.findPreguntas(id_materia);
		Respuesta[] r = new Respuesta[1000];
		PResp p[] = new PResp[1000];

		for (int i = 0; i < preguntas.size(); i++) {
			System.out.println("Pregunta: " + preguntas.get(i).getId() + " -> " + preguntas.get(i).getPregunta());
			p[i] = new PResp();
			p[i].setDesc(preguntas.get(i).getPregunta());

//			System.out.println("::::::::::::::::"+preguntas.get(i).getRespuestas()+":::::::::::::::");
//			System.out.println("-----------------"+preguntas.get(i).getRespuestas().replace("·Su latitud.", "")+"------------------");

			String[] resp = preguntas.get(i).getRespuestas().split("·");
			preguntas.get(i).setRespArray(resp);

			n = resp.length;
			for (int j = 0; j < resp.length; j++) {
				r[j] = new Respuesta();
				r[j].setDesc(resp[j]);
				// r[j].setIsTheRightAnswer(false);
				System.out.println("Respuesta [" + j + "]: " + resp[j]);

			}

			data.add(p[i]);

			System.out.println("indice.." + preguntas.get(i).getIndice());

			int indice = preguntas.get(i).getIndice();
			Evaluador evaluador = new Evaluador();
			evaluador.asigData(n, i, p, r, indice);

		}

		return data;
	}

	@PostMapping("/updateResp")
	public void updateResp(@RequestParam("respuesta") String respuesta)
	{
		
		
		
		List<Pregunta> preguntas = materiaMapper.findResp(respuesta.trim());
		String id = preguntas.get(0).getId().toString();
		
		System.out.println(":::::::::::"+preguntas.get(0).getRespuestas()+"::::::::::::");	
		
		String newData = preguntas.get(0).getRespuestas().replace("·"+respuesta, "");
		newData = newData.replace(respuesta+"·","");
		
		System.out.println(";;;;;;;;;;;;"+newData+";;;;;;;;;;;;;;;");

		materiaMapper.updateR(newData, id);
		

		
		
	}
	
}
