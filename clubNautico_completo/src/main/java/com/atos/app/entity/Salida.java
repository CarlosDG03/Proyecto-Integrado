package com.atos.app.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "Salidas")
public class Salida {

	@Id
	@Column(name = "ID_SALIDA")
	private Long idSalida;
	
	@Column(name = "FECHA_SALIDA")
	private LocalDate fechaSalida;
	
	@Column(name = "DESTINO")
	private String destino;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BARCO_FK")
	@JsonIgnoreProperties("num_salidas")
	private Barco idbarco;
	
	@Column(name = "ID_PATRON")
	private Long idPatron;

	
	
	
	
	
	
	
	public Long getIdSalida() {
		return idSalida;
	}
	public void setIdSalida(Long idSalida) {
		this.idSalida = idSalida;
	}
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Barco getIdbarco() {
		return idbarco;
	}
	public void setIdbarco(Barco idbarco) {
		this.idbarco = idbarco;
	}
	public Long getIdPatron() {
		return idPatron;
	}
	public void setIdPatron(Long idPatron) {
		this.idPatron = idPatron;
	}





	
	
	
	
	
	
	public Salida(Long idSalida, LocalDate fechaSalida, String destino, Barco idbarco, Long idPatron) {
		super();
		this.idSalida = idSalida;
		this.fechaSalida = fechaSalida;
		this.destino = destino;
		this.idbarco = idbarco;
		this.idPatron = idPatron;
	}
	public Salida() {
	
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Salida [idSalida=" + idSalida + ", fechaSalida=" + fechaSalida + ", destino=" + destino + ", idbarco="
				+ idbarco + ", idPatron=" + idPatron + "]";
	}
	
}
