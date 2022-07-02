package com.hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return reserva.getId();

	}

	public int eliminar(int idReserva) {

		try (final PreparedStatement statement = conexion.prepareStatement("DELETE FROM reservas WHERE id = ?")) {

			statement.setInt(1, idReserva);
			statement.execute();
			int cant = statement.getUpdateCount(); // devuelve cuantas filas fueron modificadas luego de realizar la consulta
			return cant;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reserva> listaReservas() {
		
		try (final java.sql.PreparedStatement statement = conexion
				.prepareStatement("SELECT fechaEntrada, fechaSalida, formaDePago, valor, id FROM reservas ORDER BY id");) {

			statement.execute();

			try (ResultSet resultSet = statement.getResultSet()) {

				List<Reserva> listaResultado = new ArrayList<>();
				while (resultSet.next()) {
					Reserva reserva = new Reserva(resultSet.getDate("fechaEntrada"), resultSet.getDate("fechaSalida"),
							resultSet.getString("formaDePago"), resultSet.getDouble("valor"), resultSet.getInt("id"));

					listaResultado.add(reserva);
				}
				return listaResultado;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	
	public int editarReserva(Reserva reserva) {
		
		try (final PreparedStatement statement = conexion.prepareStatement(
				"UPDATE reservas SET fechaEntrada = ? ,fechaSalida = ? ,valor = ? , formaDePago = ? WHERE ID = ?")){
				
			statement.setDate(1, reserva.getFechaEntrada());
			statement.setDate(2, reserva.getFechaSalida());
			statement.setDouble(3, reserva.getValor());
			statement.setString(4, reserva.getFormaDePago());
			statement.setInt(5, reserva.getId());

			System.out.println("id "+reserva.getId());
						
			statement.execute();
			int cant = statement.getUpdateCount(); // cantidad de resultados que fueron actualizados

			return cant;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Reserva getReserva(int idReserva) {

		try (final java.sql.PreparedStatement statement = conexion
				.prepareStatement("SELECT fechaEntrada, fechaSalida, formaDePago, valor, id FROM reservas WHERE id = ?");) {

			statement.setInt(1, idReserva);
			statement.execute();

			try (ResultSet resultSet = statement.getResultSet()) {
 
				Reserva reserva = null; 
				while (resultSet.next()) {
					reserva = new Reserva(resultSet.getDate("fechaEntrada"), resultSet.getDate("fechaSalida"),
							resultSet.getString("formaDePago"), resultSet.getDouble("valor"), resultSet.getInt("id"));

				}
				return reserva;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}
}
