package com.efren.ProyectoCrud.Model.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.efren.ProyectoCrud.Model.Curso.Entities.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {

	public List<Curso> findByNombreCursoContaining(String name);

}
