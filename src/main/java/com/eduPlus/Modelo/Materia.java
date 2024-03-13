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
@Table(name = "Materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMateria")
    private Integer idMateria;
    ///////////////////////////////
    //relacion con la bd
    
    
    //ya esta relacionada
    @OneToMany(mappedBy = "idMateria")
    private List<AsignacionDocente> asignacionDocente;
    
    // ya esta relacionada
    @OneToMany(mappedBy = "idMateria")
    private List<Tareas> tareas;
    
    //ya esta relacionada
    @OneToMany(mappedBy = "idMateria")
    private List<Notas> notas;

    ////////////////////////////////////
    @Column(name = "Materia", nullable = false, length = 100)
    private String materia;

    public enum Estado {
        ACTIVO, INACTIVO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = false)
    private Estado estado;

    // Getters, setters y toString a ser añadidos aquí
    
    public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(Integer idMateria, String materia, Estado estado) {
		super();
		this.idMateria = idMateria;
		this.materia = materia;
		this.estado = estado;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", materia=" + materia + ", estado=" + estado + ", getIdMateria()="
				+ getIdMateria() + ", getMateria()=" + getMateria() + ", getEstado()=" + getEstado() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
    
    
    
    
    
    
    
    
    
}