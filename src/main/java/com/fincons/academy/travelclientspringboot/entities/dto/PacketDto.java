package com.fincons.academy.travelclientspringboot.entities.dto;

public class PacketDto {

	private Long id;

	private String nomePacchetto;
	private String city;
	private String mezzoTrasporto;
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

}
