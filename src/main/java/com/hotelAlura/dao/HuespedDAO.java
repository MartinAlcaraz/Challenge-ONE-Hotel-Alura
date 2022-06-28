package com.hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelAlura.model.Huesped;

public class HuespedDAO {

	private Connection conexion;

	public HuespedDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public void registrar(Huesped huesped) {

		try (final PreparedStatement statement = conexion.prepareStatement(
				"insert into huesped (nombre, apellido, fechaNacimiento, nacionalidad, telefono, id_reserva) values(?,?,?,?,?,?)")) {

			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, huesped.getFechaNacimiento());
			statement.setString(4, huesped.getNacionalidad());
			statement.setString(5, huesped.getTelefono());
			statement.setInt(6, huesped.getId_Reserva());
			statement.execute();

			System.out.println("modificaciones: "+statement.getUpdateCount());
			
		} catch (SQLException e) {
			throw new RuntimeException(e);	
		}
	}
}
