package com.hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelAlura.model.Reserva;

public class ReservaDAO {

	private Connection conexion;

	public ReservaDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public int reservar(Reserva reserva) {

		try (final PreparedStatement statement = conexion.prepareStatement(
				"insert into reservas (fechaEntrada, fechaSalida, valor, formaDePago) values(?,?,?,?)",
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			statement.setDate(1, reserva.getFechaEntrada());
			statement.setDate(2, reserva.getFechaSalida());
			statement.setDouble(3, reserva.getValor());
			statement.setString(4, reserva.getFormaDePago());
			statement.execute();
			
			try (final ResultSet resultSet = statement.getGeneratedKeys()) {

				while (resultSet.next()) {
					reserva.setId(resultSet.getInt(1)); // el indice 1 contiene el id generado
					System.out.println("id reserva: " + reserva.getId());
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return reserva.getId();

	}

	public void eliminarReserva(int idReserva) {

		try (final PreparedStatement statement = conexion.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?")) {

			statement.setInt(1, idReserva);
			statement.execute();
			int cant = statement.getUpdateCount(); // devuelve cuantas filas fueron modificadas luego de realizar la consulta
			System.out.println("registor eliminados: " + cant);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
