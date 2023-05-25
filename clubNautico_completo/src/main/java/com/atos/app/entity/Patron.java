package com.atos.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Patron")
public class Patron {

	@Id
	@Column(name = "ID_PATRON")
	private Long idPatron;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDOS")
	private String apellidos;

	
	
	
	
	public Long getIdPatron() {
		return idPatron;
	}
	public void setIdPatron(Long idPatron) {
		this.idPatron = idPatron;
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
	
	
	
	
	
	public Patron(Long idPatron, String nombre, String apellidos) {
		this.idPatron = idPatron;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	
	
	
	
	public Patron() {

	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Patron [idPatron=" + idPatron + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
