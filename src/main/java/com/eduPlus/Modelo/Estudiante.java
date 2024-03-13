package com.eduPlus.Modelo;

import java.util.List;


import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiante")
public class Estudiante {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEstudiante")
	private Integer idEstudiante;

	
	
	/////////////////////////////////////////////
	//se hace las relaciones con la bd

	@OneToMany(mappedBy = "idEstudiante")
    private List<Notas> notas;
	
	//se hace las relaciones con la bd
	
	//ya tiene relacion
	@OneToMany(mappedBy = "idEstudiante")
	    private List<TareasEstudiante> tareasEstudiante;
	
	//ya tiene relacion
	@OneToMany(mappedBy = "idEstudiante")
    private List<Observador> observador;
	
	
	
	@OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
		    private Registro registro;
		 
	///////////////////////////////////////////	 
		 
		 
		 
		 
		 
		 
		 

	@Column(name = "Documento", unique = true, nullable = false, length = 50)
	private int documento;

	public enum TipoDocumento {
		CEDULA, TARJETA_DE_IDENTIDAD, REGISTRO_CIVIL
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TipoDocumento", nullable = false)
	private TipoDocumento tipoDocumento;

	@Column(name = "Apellidos", nullable = false, length = 60)
	private String apellidos;

	@Column(name = "Nombres", nullable = false, length = 60)
	private String nombres;

	@Column(name = "Email", unique = true, nullable = false, length = 50)
	private String email;

	@Column(name = "Password", nullable = false, length = 100)
	private String password;

	@Column(name = "Celular", nullable = false, length = 20)
	private Integer celular;

	@Column(name = "Direccion", nullable = false, length = 60)
	private String direccion;

	public enum Estado {
		ACTIVO, INACTIVO
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "Estado", nullable = false)
	private Estado estado;
	/////////////////////////////
	//relacion con la bd
	
	//ya esta relacionada
	@ManyToOne
    @JoinColumn(name = "idRol")
	private Rol idRol;
	
	//ya esta relacionada
	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
		
	///////////////////////////////////
	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante(Integer idEstudiante, int documento, TipoDocumento tipoDocumento, String apellidos,
			String nombres, String email, String password, Integer celular, String direccion, Estado estado) {
		super();
		this.idEstudiante = idEstudiante;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.email = email;
		this.password = password;
		this.celular = celular;
		this.direccion = direccion;
		this.estado = estado;
	}

	public Integer getIdUsuario() {
		return idEstudiante;
	}

	public void setIdUsuario(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Estudiante [idEstudiante=" + idEstudiante + ", notas=" + notas + ", tareasEstudiante="
				+ tareasEstudiante + ", observador=" + observador + ", registro=" + registro + ", documento="
				+ documento + ", tipoDocumento=" + tipoDocumento + ", apellidos=" + apellidos + ", nombres=" + nombres
				+ ", email=" + email + ", password=" + password + ", celular=" + celular + ", direccion=" + direccion
				+ ", estado=" + estado + ", idRol=" + idRol + ", idUsuario=" + idUsuario + "]";
	}



	

	
	

}
