package com.efren.ProyectoCrud.Model.Services;

import java.util.List;
import com.efren.ProyectoCrud.Model.DTO.CursoDto;

public interface ICursoService {
	
	Integer guardarCurso(CursoDto cursoDto);

	List<CursoDto> getCursos(); 

	CursoDto getCursoByID(Integer id);

	void borrarById(Integer id);

	List<CursoDto> getCursosByFiltro(String nombreCurso, String familiaProfesional);

}
