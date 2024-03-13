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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tareas")
public class Tareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTareas")
    private Integer idTareas;
    
    
    /////////////////////////////////
    //relacion con la bd
    @OneToMany(mappedBy = "idTarea")
    private List<TareasEstudiante> tareasEstudiante;
    
    
    

    @Column(name = "Fecha")
    private Date fecha;

    public enum Periodo {
        PRIMER_PERIODO, SEGUNDO_PERIODO, TERCER_PERIODO, CUARTO_PERIODO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Periodo", nullable = false)
    private Periodo periodo;

    @Column(name = "Tarea", nullable = false, length = 500)
    private String tarea;

    @Column(name = "Fecha_de_Entrega")
    private Date fecha_de_entrega;

    //////////////////////////////////////////
    //relacion con la bd
    
    // ya esta relacionada
    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia idMateria;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    
    // ya esta relacionada
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso idCurso;
    
    //ya tiene todas la relaciones TERMINADA
    //////////////////////////////////////////////
    
    // Getters, setters y toString a ser añadidos aquí
    
    public Tareas() {
		// TODO Auto-generated constructor stub
	}

	public Tareas(Integer idTareas, Date fecha, Periodo periodo, String tarea, Date fecha_de_entrega) {
		super();
		this.idTareas = idTareas;
		this.fecha = fecha;
		this.periodo = periodo;
		this.tarea = tarea;
		this.fecha_de_entrega = fecha_de_entrega;
	}

	public Integer getIdTareas() {
		return idTareas;
	}

	public void setIdTareas(Integer idTareas) {
		this.idTareas = idTareas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Date getFecha_de_entrega() {
		return fecha_de_entrega;
	}

	public void setFecha_de_entrega(Date fecha_de_entrega) {
		this.fecha_de_entrega = fecha_de_entrega;
	}

	public Materia getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Materia idMateria) {
		this.idMateria = idMateria;
	}


	public List<TareasEstudiante> getTareasEstudiante() {
		return tareasEstudiante;
	}

	public void setTareasEstudiante(List<TareasEstudiante> tareasEstudiante) {
		this.tareasEstudiante = tareasEstudiante;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public String toString() {
		return "Tareas [idTareas=" + idTareas + ", tareasEstudiante=" + tareasEstudiante + ", fecha=" + fecha
				+ ", periodo=" + periodo + ", tarea=" + tarea + ", fecha_de_entrega=" + fecha_de_entrega
				+ ", idMateria=" + idMateria + ", idUsuario=" + idUsuario + ", idCurso=" + idCurso + "]";
	}
 
}