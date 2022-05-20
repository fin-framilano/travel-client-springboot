package com.fincons.academy.travelclientspringboot.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "packet")
public class Packet implements Serializable {

	private static final long serialVersionUID = -3036998512328511782L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nomepacchetto")
	private String nomePacchetto;
	@Column(name="city")
	private String city;
	@Column(name="mezzotrasporto")
	private String mezzoTrasporto;
	@Column(name="costo")
	private float costo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomePacchetto() {
		return nomePacchetto;
	}
	public void setNomePacchetto(String nomePacchetto) {
		this.nomePacchetto = nomePacchetto;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMezzoTrasporto() {
		return mezzoTrasporto;
	}
	public void setMezzoTrasporto(String mezzoTrasporto) {
		this.mezzoTrasporto = mezzoTrasporto;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
