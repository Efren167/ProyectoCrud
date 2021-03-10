package com.efren.ProyectoCrud.Model.DTO;

public class CursoDto {

	private int pK_CursoId;
	private String nombreCurso;
	private String familiaProfesional;
	private String empleabilidad;

	public int getpK_CursoId() {
		return pK_CursoId;
	}

	public void setpK_CursoId(int pK_CursoId) {
		this.pK_CursoId = pK_CursoId;
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

	public String getEmpleabilidad() {
		return empleabilidad;
	}

	public void setEmpleabilidad(String empleabilidad) {
		this.empleabilidad = empleabilidad;
	}

}
