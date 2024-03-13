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
@Table(name = "TareasEstudiante")
public class TareasEstudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTareasEstudiantes")
	private Integer idTareasEstudiantes;

	@Column(name = "FechaEnvio")
	private Date fechaEnvio;

	public enum Estado {
		ENTREGADA, SIN_ENTREGAR
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "Estado", nullable = false)
	private Estado estado;

	@Column(name = "Calificacion", nullable = false, length = 100)
	private String calificacion;
	
	
	@Column(name = "Archivos", nullable = false, length = 100)
	private String Archivos;
	

	////////////////////////////////////////
	//aqui van las conexiones con la bd
	
	//ya esta relacionada
	@ManyToOne
    @JoinColumn(name = "idEstudiante")
	private Estudiante idEstudiante;
	
	//ya esta relacionada
	@ManyToOne
    @JoinColumn(name = "idTarea")
	private Tareas idTarea;

	////////////////////////////////////////

	// Getters, setters y toString a ser añadidos aquí

	public TareasEstudiante() {
		// TODO Auto-generated constructor stub
	}

	public TareasEstudiante(Integer idTareasEstudiantes, Date fechaEnvio, Estado estado, String calificacion,
			String archivos) {
		super();
		this.idTareasEstudiantes = idTareasEstudiantes;
		this.fechaEnvio = fechaEnvio;
		this.estado = estado;
		this.calificacion = calificacion;
		Archivos = archivos;
	}

	public Integer getIdTareasEstudiantes() {
		return idTareasEstudiantes;
	}

	public void setIdTareasEstudiantes(Integer idTareasEstudiantes) {
		this.idTareasEstudiantes = idTareasEstudiantes;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getArchivos() {
		return Archivos;
	}

	public void setArchivos(String archivos) {
		Archivos = archivos;
	}

	

	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Tareas getIdTareas() {
		return idTarea;
	}

	public void setIdTareas(Tareas idTareas) {
		this.idTarea = idTareas;
	}

	@Override
	public String toString() {
		return "TareasEstudiante [idTareasEstudiantes=" + idTareasEstudiantes + ", fechaEnvio=" + fechaEnvio
				+ ", estado=" + estado + ", calificacion=" + calificacion + ", Archivos=" + Archivos
				+ ", idEstudiantes=" + idEstudiante + ", idTareas=" + idTarea + "]";
	}



	

}
