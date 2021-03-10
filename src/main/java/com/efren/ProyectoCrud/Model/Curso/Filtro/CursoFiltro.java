package com.efren.ProyectoCrud.Model.Curso.Filtro;

public class CursoFiltro {

	private String nombreCurso;
	private String familiaProfesional;

	public CursoFiltro() {// este constructor llama a cualquier subclase de la superclase Object

		super();
	}

	public CursoFiltro(String nombreCurso, String familiaProfesional) {

		super();
		this.nombreCurso = nombreCurso;
		this.familiaProfesional = familiaProfesional;

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
