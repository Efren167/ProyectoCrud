package com.efren.ProyectoCrud.Model.Curso.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Define que esta clase es la entidad
@Table(name = "CursosEFR") // establece el nombre de la tabla de la base de datos
public class Curso {

	
	@Id// Declaramos que PK_CursoID es la id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // la estrategia de autoincrementación afecta solo a la id
	@Column(name = "PK_CursoID")
	private Integer pk_CursoId;

	// Declaramos el nombre de las columnas estableciendo longitud de caracteres, si se puede
	// repetir o no y si es null
	@Column(name = "NombreCurso", length = 100, unique = true, nullable = false)
	private String nombreCurso;
	@Column(name = "FamiliaProfesional", length = 50, unique = false, nullable = false)
	private String familiaProfesional;

	public Integer getPk_CursoId() {
		return pk_CursoId;
	}

	public void setPk_CursoId(Integer pk_CursoId) {
		this.pk_CursoId = pk_CursoId;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getFamiliaProfesional() {
		return familiaProfesional;
	}

	public void setFamiliaProfesional(String familiaProfesional) {
		this.familiaProfesional = familiaProfesional;
	}

}
