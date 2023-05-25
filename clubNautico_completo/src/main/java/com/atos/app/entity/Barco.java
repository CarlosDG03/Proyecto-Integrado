package com.atos.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "Barcos")
public class Barco {

	@Id
	@Column(name = "MATRICULA")
	private String matricula;
	
	@Column(name = "NUM_AMARRE")
	private String numAmarre;
	
	@Column(name = "CUOTA")
	private String cuota;
	
	@OneToMany(mappedBy = "idbarco", cascade = CascadeType.ALL)
	private List<Salida> num_salidas = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOCIO_FK")
	@JsonIgnoreProperties("num_barcos")
	private Socio idsocio;
	
	
	
	
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNumAmarre() {
		return numAmarre;
	}
	public void setNumAmarre(String numAmarre) {
		this.numAmarre = numAmarre;
	}
	public String getCuota() {
		return cuota;
	}
	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	public List<Salida> getNum_salidas() {
		return num_salidas;
	}
	public void setNum_salidas(List<Salida> num_salidas) {
		this.num_salidas = num_salidas;
	}
	public Socio getIdsocio() {
		return idsocio;
	}
	public void setIdsocio(Socio idsocio) {
		this.idsocio = idsocio;
	}
	
	
	public Barco(String matricula, String numAmarre, String cuota, List<Salida> num_salidas, Socio idsocio) {
		super();
		this.matricula = matricula;
		this.numAmarre = numAmarre;
		this.cuota = cuota;
		this.num_salidas = num_salidas;
		this.idsocio = idsocio;
	}
	public Barco() {
		
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Barco [matricula=" + matricula + ", numAmarre=" + numAmarre + ", cuota=" + cuota + ", num_salidas="
				+ num_salidas + ", idsocio=" + idsocio + "]";
	}
	
}
