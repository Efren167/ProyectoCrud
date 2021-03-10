package com.efren.ProyectoCrud.Model.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efren.ProyectoCrud.Model.Curso.Entities.Curso;
import com.efren.ProyectoCrud.Model.DTO.CursoDto;
import com.efren.ProyectoCrud.Model.Repositories.ICursoRepository;

@Service
public class CursoService implements ICursoService {

	@Autowired
	ICursoRepository cursoRepository;

	@Override
	public Integer guardarCurso(CursoDto cursoDto) {

		Curso curso = this.mapDtoToEntity(cursoDto);
		curso = cursoRepository.save(curso);
		return curso.getPk_CursoId();

	}

	@Override
	public List<CursoDto> getCursos() {

		List<CursoDto> resultado = null;

		List<Curso> cursos = cursoRepository.findAll();

		if (cursos != null && cursos.size() > 0) {

			resultado = new ArrayList<CursoDto>();

			for (Curso cur : cursos) {

				resultado.add(this.mapEntityToDto(cur));
			}
		}

		return resultado;
	}

	@Override
	public CursoDto getCursoByID(Integer id) {

		Optional<Curso> curso = cursoRepository.findById(id);

		if (curso.isPresent()) {

			return this.mapEntityToDto(curso.get());

		} else {

			return new CursoDto();
		}

	}

	@Override
	public void borrarById(Integer id) {

		cursoRepository.deleteById(id);

	}

	@Override
	public List<CursoDto> getCursosByFiltro(String nombreCurso, String familiaProfesional) {

		List<CursoDto> resultado = null;

		List<Curso> cursos = cursoRepository.findByNombreCursoContaining(nombreCurso);

		if (cursos != null && cursos.size() > 0) {

			resultado = new ArrayList<CursoDto>();

			for (Curso cur : cursos) {

				resultado.add(this.mapEntityToDto(cur));
			}
		}
		return resultado;
	}

	private Curso mapDtoToEntity(CursoDto cursoDto) {

		Curso curso = new Curso();

		if (cursoDto.getNombreCurso() != null) {

			curso.setPk_CursoId(cursoDto.getpK_CursoId());
		}

		curso.setNombreCurso(cursoDto.getNombreCurso());
		curso.setFamiliaProfesional(cursoDto.getFamiliaProfesional());

		return curso;
	}

	private CursoDto mapEntityToDto(Curso cursoEntidad) {

		CursoDto cursoDto = new CursoDto();

		cursoDto.setpK_CursoId(cursoEntidad.getPk_CursoId());
		cursoDto.setNombreCurso(cursoEntidad.getNombreCurso());
		cursoDto.setFamiliaProfesional(cursoEntidad.getFamiliaProfesional());

		if (cursoDto.getFamiliaProfesional() != null && cursoDto.getFamiliaProfesional().toUpperCase().equals("TIC")) {

			cursoDto.setEmpleabilidad("Empleabilidad alta");

		} else {

			cursoDto.setEmpleabilidad("Empleabilidad normal");
		}

		return cursoDto;

	}

}
