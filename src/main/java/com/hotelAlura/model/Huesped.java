package com.hotelAlura.model;

import java.sql.Date;

public class Huesped {

	private String nombre;
	private String apellido;
	private String nacionalidad;
	private String telefono;
	private Date fechaNacimiento;
	private Integer id_Reserva;
	
	public Huesped (String nombre, String apellido, Date fechaNac, String nacionalidad, String telefono, Integer id_reserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNac;
		this.id_Reserva = id_reserva;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId_Reserva() {
		return id_Reserva;
	}

	public void setId_Reserva(Integer id_Reserva) {
		this.id_Reserva = id_Reserva;
	}
	
	
	
}
