package com.eduPlus.Modelo;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurso")
    private Integer idCurso;
    ////////////////////////////
    //relacion con la bd
    
    //ya esta relacionada
    @OneToMany(mappedBy = "idCurso")
    private List<AsignacionDocente> asignacionDocente;
    
    
    //ya tiene relacion
    @OneToMany(mappedBy = "idCurso")
    private List<Notas> notas;
    
    
    
    // ya tiene relacion
    @OneToMany(mappedBy = "idCurso")
    private List<Tareas> tareas;
    
    
    // ya tiene relacion
    @OneToMany(mappedBy = "idCurso")
    private List<Registro> registro;
    
    
    //ya tiene relacion
    @OneToMany(mappedBy = "idCurso")
    private List<Observador> observador;
    
    ///////////////////////////////////////
    
    @Column(name = "Curso", nullable = false, length = 100)
    private String curso;

    public enum Estado {
        ACTIVO, INACTIVO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = false)
    private Estado estado;

    // Getters, setters y toString a ser añadidos aquí
    
    public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(Integer idCurso, String curso, Estado estado) {
		super();
		this.idCurso = idCurso;
		this.curso = curso;
		this.estado = estado;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", curso=" + curso + ", estado=" + estado + ", getIdCurso()="
				+ getIdCurso() + ", getCurso()=" + getCurso() + ", getEstado()=" + getEstado() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
    
    
    
    
    
    
    
    
    
}