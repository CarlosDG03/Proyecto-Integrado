package com.atos.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "Socios")
public class Socio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOCIO")
	private Long idSocio;
	
	@Column(name = "NOMBRE_SOCIO")
	private String nombre;
	
	@Column(name = "APELLIDOS_SOCIO")
	private String apellidos;
	
	@Column
	@OneToMany(mappedBy = "idsocio", cascade = CascadeType.ALL)
	private List<Barco> num_barcos = new ArrayList<>();
	
	

	
	
	public Long getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(Long idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Barco> getNum_barcos() {
		return num_barcos;
	}

	public void setNum_barcos(List<Barco> num_barcos) {
		this.num_barcos = num_barcos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public Socio() {
	
	}
	public Socio(Long idSocio, String nombre, String apellidos, List<Barco> num_barcos) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.num_barcos = num_barcos;
	}
	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", nombre=" + nombre + ", apellidos=" + apellidos + ", num_barcos="
				+ num_barcos + "]";
	}
	
	
	
}

	
