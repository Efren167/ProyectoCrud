package com.efren.ProyectoCrud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.efren.ProyectoCrud.Model.Curso.Filtro.CursoFiltro;
import com.efren.ProyectoCrud.Model.DTO.CursoDto;
import com.efren.ProyectoCrud.Model.Services.ICursoService;

@Controller
public class CursoController {

	@Autowired
	ICursoService cursoService;

	@GetMapping("/ListaCursos")
	public ModelAndView listaCursos() {

		ModelAndView modelAndView = new ModelAndView();

		List<CursoDto> cursos = cursoService.getCursos();

		modelAndView.addObject("CursoDTOLista", cursos);
		modelAndView.addObject("CursoDTOFiltro", new CursoFiltro());
		modelAndView.setViewName("ListaCursos");

		return modelAndView;
	}

	@GetMapping("/NuevoCurso")
	public ModelAndView nuevaDelegacion() {

		ModelAndView modelAndView = new ModelAndView();
		CursoDto cursoDto = new CursoDto();

		modelAndView.addObject("CursoDTOForm", cursoDto);
		modelAndView.setViewName("EditarCurso");

		return modelAndView;

	}

	@PostMapping("/FiltrarCursos")
	public ModelAndView filtrarCurso(@ModelAttribute("CursoDTOFiltro") CursoFiltro cursoFiltro) {

		ModelAndView modelAndView = new ModelAndView();
		List<CursoDto> cursos = cursoService.getCursosByFiltro(cursoFiltro.getNombreCurso(),
				cursoFiltro.getFamiliaProfesional());

		modelAndView.addObject("CursoDTOLista", cursos);
		modelAndView.addObject("CursoDTOFiltro", new CursoFiltro());
		modelAndView.setViewName("ListaCursos");

		return modelAndView;

	}

	@GetMapping("/EditarCurso/{id}")
	public ModelAndView editarCurso(@PathVariable("id") Integer id) {

		ModelAndView modelAndView = new ModelAndView();
		CursoDto cursoDto = cursoService.getCursoByID(id);
		modelAndView.addObject("CursoDTOForm", cursoDto);
		modelAndView.setViewName("EditarCurso");
		return modelAndView;
	}

	@GetMapping("/BorrarCurso/{id}")
	public ModelAndView borrarDelegacion(@PathVariable("id") Integer id) {

		cursoService.borrarById(id);
		return new ModelAndView("redirect:/ListaCursos");
	}

	@GetMapping("VerDetalleCurso/{id}")
	public ModelAndView verDetalleCurso(@PathVariable("id") Integer id) {
		System.out.println("Id: " + id);
		ModelAndView modelAndView = new ModelAndView();
		CursoDto cursoDto = cursoService.getCursoByID(id);
		modelAndView.addObject("CursoDTODetalle", cursoDto);
		modelAndView.setViewName("DetalleCurso");

		return modelAndView;
	}

	@PostMapping("/GuardarCurso")
	public ModelAndView guardarDelegacion(@ModelAttribute("CursoDTOForm") CursoDto cursoDto) {
		cursoService.guardarCurso(cursoDto);
		return new ModelAndView("redirect:/ListaCursos");
	}

}
