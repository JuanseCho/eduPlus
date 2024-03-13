package com.eduPlus.Modelo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Observador")
public class Observador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idObservador")
    private Integer idObservador;

    @Column(name = "Fecha")
    private Date fecha;

    public enum Tipo {
        ACTIVO, INACTIVO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo", nullable = false)
    private Tipo tipo;

    @Column(name = "Observacion", nullable = false, length = 500)
    private String observacion;

    @Column(name = "TratamientoAplicado", nullable = false, length = 500)
    private String tratamientoAplicado;

    @Column(name = "Compromisos", nullable = false, length = 500)
    private String compromisos;

    
    ///////////////////////////////
    //relacion con la bd
    
    //ya tiene relacion
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso idCurso;
    
    //ya tiene relacion
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante idEstudiante;
    
    //ya tiene relacion
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
 
    ///////////////////////////////////
 
    // Getters, setters y toString a ser añadidos aquí
    
    public Observador() {
		// TODO Auto-generated constructor stub
	}

	public Observador(Integer idObservador, Date fecha, Tipo tipo, String observacion, String tratamientoAplicado,
			String compromisos) {
		super();
		this.idObservador = idObservador;
		this.fecha = fecha;
		this.tipo = tipo;
		this.observacion = observacion;
		this.tratamientoAplicado = tratamientoAplicado;
		this.compromisos = compromisos;
	}

	public Integer getIdObservador() {
		return idObservador;
	}

	public void setIdObservador(Integer idObservador) {
		this.idObservador = idObservador;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTratamientoAplicado() {
		return tratamientoAplicado;
	}

	public void setTratamientoAplicado(String tratamientoAplicado) {
		this.tratamientoAplicado = tratamientoAplicado;
	}

	public String getCompromisos() {
		return compromisos;
	}

	public void setCompromisos(String compromisos) {
		this.compromisos = compromisos;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}



	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Observador [idObservador=" + idObservador + ", fecha=" + fecha + ", tipo=" + tipo + ", observacion="
				+ observacion + ", tratamientoAplicado=" + tratamientoAplicado + ", compromisos=" + compromisos
				+ ", idCurso=" + idCurso + ", idEstudiante=" + idEstudiante + ", idUsuario=" + idUsuario + "]";
	}

	

	

	

	

	

	
	

	
    
    
    
    
    
    
    
}