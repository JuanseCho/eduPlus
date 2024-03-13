package com.eduPlus.Modelo;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;
    
    
    
    
    ///////////////////////////////////////
    //relacion con la bd
    
    //ya esta relacionada
    @OneToMany(mappedBy = "idRol")
    private List<Usuario> usuario;
    
    //ya esta relacionada
    @OneToMany(mappedBy = "idRol")
    private List<Estudiante> estudiantes;
    
    
    
    /////////////////////////////////////////////
    
    @Column(name = "Rol", nullable = false, length = 100)
    private String rol;

    // Getters, setters y toString a ser añadidos aquí
    
    public Rol() {
		// TODO Auto-generated constructor stub
	}

	public Rol(Integer idRol, String rol) {
		super();
		this.idRol = idRol;
		this.rol = rol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", rol=" + rol + ", getIdRol()=" + getIdRol() + ", getRol()=" + getRol()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
