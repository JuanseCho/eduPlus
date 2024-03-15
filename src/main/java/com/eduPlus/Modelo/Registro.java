package com.eduPlus.Modelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(Registro.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistro")
    private Integer idRegistro;

    @Column(name = "Ano", nullable = false)
    private int ano;

    @Column(name = "NoLista", nullable = false)
    private int noLista;

    @OneToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso idCurso;

    public Registro() {
    }

    public Registro(Integer idRegistro, int ano, int noLista) {
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

    
    
    //////////////ESTO VA EN EL CONTROLADOR///////////////
    //CONDICIONAL PARA QUE SI HAY UN USUARIO CON EL MISMO ID NO LO DEJE REGISTRAR Y SI NO SI LO DEJE REGISTRAR 
//    public Estudiante getEstudiante() {
//        return estudiante;
//    }
//
//    public void setEstudiante(Estudiante estudiante) {
//        if (this.estudiante != null) {
//            LOGGER.warn("¡Alerta! Este registro ya tiene un estudiante asignado.");
//        } else {
//            this.estudiante = estudiante;
//            estudiante.setRegistro(this);
//        }
//    }
    
    ////////////////////////////////////////////////////

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
