package com.hotelAlura.controller;

import java.sql.Connection;
import java.util.List;

import com.hotelAlura.dao.UsuarioDAO;
import com.hotelAlura.factory.ConnectionFactory;
import com.hotelAlura.model.Usuario;

public class UsuarioController {

	private UsuarioDAO usuarioDao;
	
	public UsuarioController() {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexion = factory.conectar();
		this.usuarioDao = new UsuarioDAO(conexion);
	}
	
	public List<Usuario> listar(){
		return usuarioDao.listar();
	}
}
