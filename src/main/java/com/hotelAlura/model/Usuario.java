package com.hotelAlura.model;

public class Usuario {

	private String nombreUsuario;
	private String password;
	
	public Usuario(String nombreUsuario, String password) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public String getnombreUsuario() {
		return this.nombreUsuario;
	}
	public String getPassword() {
		return this.password;
	}
	
}
