package com.fincons.academy.travelclientspringboot.entities.dto;

public class ReservationDto {

	private Long id;
	private Long userId;
	private Long packetId;
	private String startDate;
	private String endDate;
	private Integer nrPeople;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPacketId() {
		return packetId;
	}

	public void setPacketId(Long packetId) {
		this.packetId = packetId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getNrPeople() {
		return nrPeople;
	}

	public void setNrPeople(Integer nrPeople) {
		this.nrPeople = nrPeople;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += " " + this.endDate;
		s += " " + this.startDate;
		s += " " + this.packetId;
		s += " " + this.userId;
		return s;
		
	}

}
