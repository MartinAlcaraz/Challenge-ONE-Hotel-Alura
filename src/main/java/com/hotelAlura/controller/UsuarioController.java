package com.hotelAlura.controller;

import java.sql.Connection;
import java.util.List;

import com.hotelAlura.dao.UsuarioDAO;
import com.hotelAlura.factory.ConnectionFactory;

public class UsuarioController {

	private UsuarioDAO usuarioDao;
	
	public UsuarioController() {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexion = factory.conectar();
		this.usuarioDao = new UsuarioDAO(conexion);
	}

	public boolean login(String user, String password) {
		return usuarioDao.login(user, password);
	}
	
	public int crearUsuario(String user, String password) {
		return usuarioDao.crearUsuario(user, password);
	}
		
	public List<String> listaUsuarios(){
		return usuarioDao.listaUsuarios();
	}
}
