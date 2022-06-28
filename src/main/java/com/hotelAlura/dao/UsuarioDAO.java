package com.hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hotelAlura.model.Usuario;

public class UsuarioDAO {

	private Connection conexion;

	public UsuarioDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public List<Usuario> listar(){
		List<Usuario> lista = new ArrayList<>();
		try (final PreparedStatement statement = conexion.prepareStatement("select user, password from usuarios")) {

			try (final ResultSet resultSet = statement.executeQuery()) {
				
				while (resultSet.next()) {
					String nombre = resultSet.getString("user");
					String password = resultSet.getString("password");
					Usuario user = new Usuario(nombre, password);
					
					lista.add(user);
				}
				
			}
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		
		return Collections.unmodifiableList(lista);
	}
}
