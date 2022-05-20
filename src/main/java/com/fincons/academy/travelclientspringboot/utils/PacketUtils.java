package com.fincons.academy.travelclientspringboot.utils;

import com.fincons.academy.travelclientspringboot.entities.Packet;
import com.fincons.academy.travelclientspringboot.entities.dto.PacketDto;

public class PacketUtils {

	public static PacketDto fromDVOtoDTO(Packet p) {
		PacketDto packetDto = new PacketDto();
		packetDto.setId(p.getId());
		packetDto.setCity(p.getCity());
		packetDto.setCosto(p.getCosto());
		packetDto.setMezzoTrasporto(p.getMezzoTrasporto());
		packetDto.setNomePacchetto(p.getNomePacchetto());
		return packetDto;
	}
	
	public static Packet fromDTOtoDVO(PacketDto p) {
		Packet packet = new Packet();
		packet.setId(p.getId());
		packet.setCity(p.getCity());
		packet.setCosto(p.getCosto());
		packet.setMezzoTrasporto(p.getMezzoTrasporto());
		packet.setNomePacchetto(p.getNomePacchetto());
		return packet;
	}

}
