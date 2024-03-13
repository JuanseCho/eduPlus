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

@Entity
@Table(name = "Notas")
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotas")
    private Integer idNotas;

    public enum Periodo {
        PRIMER_PERIODO, SEGUNDO_PERIODO, TERCER_PERIODO, CUARTO_PERIODO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Periodo", nullable = false)
    private Periodo periodo;

    @Column(name = "DescripcionNota", nullable = false, length = 500)
    private String descripcionNota;

    @Column(name = "Nota", nullable = false, length = 500)
    private String nota;

    public enum Desempeno {
        INSUFICIENTE, SOBRESALIENTE, EXCELENTE
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Desempeno", nullable = false)
    private Desempeno desempeno;

    @Column(name = "Fallas", nullable = false)
    private int fallas;

    @Column(name = "Comportamiento", nullable = false, length = 500)
    private String comportamiento;

    
    
    ////////////////////////////////////////
    //aqui van las conexiones con la bd
    
    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia idMateria;

    
    //ya tiene relacion
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante idEstudiante;
    
    //ya tiene relacion
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso idCurso;
    
  //ya tiene relacion
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    
    ////////////////////////////////////////
    
    
    // Getters, setters y toString a ser añadidos aquí
    
    public Notas() {
		// TODO Auto-generated constructor stub
	}
    
    

	public Notas(Integer idNotas, Periodo periodo, String descripcionNota, String nota, Desempeno desempeno, int fallas,
			String comportamiento) {
		super();
		this.idNotas = idNotas;
		this.periodo = periodo;
		this.descripcionNota = descripcionNota;
		this.nota = nota;
		this.desempeno = desempeno;
		this.fallas = fallas;
		this.comportamiento = comportamiento;
	}



	public Periodo getPeriodo() {
		return periodo;
	}



	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}



	public String getDescripcionNota() {
		return descripcionNota;
	}



	public void setDescripcionNota(String descripcionNota) {
		this.descripcionNota = descripcionNota;
	}



	public String getNota() {
		return nota;
	}



	public void setNota(String nota) {
		this.nota = nota;
	}



	public Desempeno getDesempeno() {
		return desempeno;
	}



	public void setDesempeno(Desempeno desempeno) {
		this.desempeno = desempeno;
	}



	public int getFallas() {
		return fallas;
	}



	public void setFallas(int fallas) {
		this.fallas = fallas;
	}



	public String getComportamiento() {
		return comportamiento;
	}



	public void setComportamiento(String comportamiento) {
		this.comportamiento = comportamiento;
	}



	@Override
	public String toString() {
		return "Notas [idNotas=" + idNotas + ", periodo=" + periodo + ", descripcionNota=" + descripcionNota + ", nota="
				+ nota + ", desempeno=" + desempeno + ", fallas=" + fallas + ", comportamiento=" + comportamiento
				+ ", idMateria=" + idMateria + ", idEstudiante=" + idEstudiante + ", idCurso=" + idCurso
				+ ", idUsuario=" + idUsuario + "]";
	}



    
    
    
    
}