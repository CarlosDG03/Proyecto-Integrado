package com.atos.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@Column(name = "ID_ADMIN")
	private Long idAdmin;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "CONTRASEÑA")
	private String contraseña;

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public Admin(Long idAdmin, String correo, String contraseña) {
		super();
		this.idAdmin = idAdmin;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public Admin() {
	}

	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", correo=" + correo + ", contraseña=" + contraseña + "]";
	}
	
	
	
	
}


