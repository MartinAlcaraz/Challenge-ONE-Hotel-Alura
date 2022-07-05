package com.hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

	private Connection conexion;

	public UsuarioDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public boolean login(String user, String password){
		
		boolean ok = false;
		try (final PreparedStatement statement = conexion.prepareStatement(
				"SELECT user, password FROM usuarios WHERE user = ? AND password = (aes_encrypt( ?, 'llave'))")) {

			statement.setString(1, user);
			statement.setString(2, password);
			statement.execute();
			try (final ResultSet resultSet = statement.getResultSet()) {
				while (resultSet.next()) {
					ok = true;
				}
			}
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		
		return ok;
	}

	public int crearUsuario(String user, String password) {
		int cant;
		try (final PreparedStatement statement = conexion.prepareStatement(
				"INSERT INTO usuarios (user, password) VALUES ( ? , aes_encrypt( ? , 'llave'));",
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, user);
			statement.setString(2, password);
			statement.execute();

			cant = statement.getUpdateCount();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cant;
	}
	
	public List<String> listaUsuarios() {
		ArrayList<String> lista = new ArrayList<String>();
		try (final PreparedStatement statement = conexion.prepareStatement(
				"SELECT user FROM usuarios")) {

			statement.execute();
			try(ResultSet resultSet = statement.getResultSet()){
				
				while(resultSet.next()) {
					lista.add(resultSet.getString("user"));
				}
				return lista;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

//Collections.unmodifiableList(lista)