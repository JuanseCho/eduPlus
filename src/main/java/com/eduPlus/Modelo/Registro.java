package com.eduPlus.Modelo;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistro")
    private Integer idRegistro;

    @Column(name = "Ano", nullable = false)
    private int ano;

    @Column(name = "NoLista", nullable = false)
    private int noLista;

    // Getters, setters y toString a ser añadidos aquí
    
    ////////////////////////////////
    //relacion con la bd
    
    //ya esta relacionada
    
    @OneToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;
    
    // ya esta relacionada
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso idCurso;
    
    
    
    
    
    
    /////////////////////////////////////
    
    public Registro() {
		// TODO Auto-generated constructor stub
	}

	public Registro(Integer idRegistro, int ano, int noLista) {
		super();
		this.idRegistro = idRegistro;
		this.ano = ano;
		this.noLista = noLista;
	}

	public Integer getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNoLista() {
		return noLista;
	}

	public void setNoLista(int noLista) {
		this.noLista = noLista;
	}
	
	
	
	



	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public String toString() {
		return "Registro [idRegistro=" + idRegistro + ", ano=" + ano + ", noLista=" + noLista + ", estudiante="
				+ estudiante + ", idCurso=" + idCurso + "]";
	}


	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
