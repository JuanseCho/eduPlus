package com.eduPlus.Modelo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AsignacionDocente")
public class AsignacionDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsignacionDocente")
    private Integer idAsignacionDocente;
    
    

    @Column(name = "Ano", nullable = false)
    private int ano;

    @Column(name = "DirectorCurso", nullable = false, length = 100)
    private String directorCurso;
    
    
    
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso idCurso;
    
    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia idMateria;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    
     	

    // Getters, setters y toString a ser añadidos aquí
    
    public AsignacionDocente() {
		// TODO Auto-generated constructor stub
	}

	public AsignacionDocente(Integer idAsignacionDocente, int ano, String directorCurso) {
		super();
		this.idAsignacionDocente = idAsignacionDocente;
		this.ano = ano;
		this.directorCurso = directorCurso;
	}

	
	
	
	
	public Integer getIdAsignacionDocente() {
		return idAsignacionDocente;
	}

	public void setIdAsignacionDocente(Integer idAsignacionDocente) {
		this.idAsignacionDocente = idAsignacionDocente;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDirectorCurso() {
		return directorCurso;
	}

	public void setDirectorCurso(String directorCurso) {
		this.directorCurso = directorCurso;
	}
	
	

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	
	
	public Materia getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Materia idMateria) {
		this.idMateria = idMateria;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "AsignacionDocente [idAsignacionDocente=" + idAsignacionDocente + ", ano=" + ano + ", directorCurso="
				+ directorCurso + ", idCurso=" + idCurso + ", idMateria=" + idMateria + ", idUsuario=" + idUsuario
				+ "]";
	}

	

	
	
	
	
	

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}