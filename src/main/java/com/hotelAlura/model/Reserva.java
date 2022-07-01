package com.hotelAlura.model;

import java.sql.Date;

public class Reserva {

	private int id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String formaDePago;
	private Double valor;
	
	public Reserva(Date fEntrada, Date fSalida, String fDePago, Double valor) {
		this.fechaEntrada = fEntrada;
		this.fechaSalida = fSalida;
		this.formaDePago = fDePago;
		this.valor = valor;
	}

	public Reserva(Date fEntrada, Date fSalida, String fDePago, Double valor, int id) {
		this.fechaEntrada = fEntrada;
		this.fechaSalida = fSalida;
		this.formaDePago = fDePago;
		this.valor = valor;
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public String getFormaDePago() {
		return this.formaDePago;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
