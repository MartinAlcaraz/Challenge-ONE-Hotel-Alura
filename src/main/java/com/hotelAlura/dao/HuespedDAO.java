package com.hotelAlura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Huesped> listaHuespedes() {
		

		try (final java.sql.PreparedStatement statement = conexion
				.prepareStatement("SELECT nombre, apellido, fechaNacimiento, nacionalidad, telefono, id_reserva FROM huesped ORDER BY apellido");) {

			statement.execute();

			try (ResultSet resultSet = statement.getResultSet()) {

				List<Huesped> listaResultado = new ArrayList<>();
				while (resultSet.next()) {
					Huesped huesped = new Huesped(resultSet.getString("nombre"), resultSet.getString("apellido"),
							resultSet.getDate("fechaNacimiento"), resultSet.getString("nacionalidad"), 
							resultSet.getString("telefono"), resultSet.getInt("id_reserva"));

					listaResultado.add(huesped);
				}
				return listaResultado;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public int eliminar(Integer id_reserva) {
		try (final PreparedStatement statement = conexion.prepareStatement("DELETE FROM huesped WHERE id_reserva = ?")) {

			statement.setInt(1, id_reserva);
			statement.execute();
			int cant = statement.getUpdateCount(); // devuelve cuantas filas fueron modificadas luego de realizar la consulta
			return cant;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Huesped getHuesped(int idReserva) {
		
		try (final java.sql.PreparedStatement statement = conexion
				.prepareStatement("SELECT nombre, apellido, fechaNacimiento, nacionalidad, telefono FROM huesped WHERE id_reserva = ?");) {

			statement.setInt(1, idReserva);
			statement.execute();

			try (ResultSet resultSet = statement.getResultSet()) {

				Huesped huesped = null;
				while (resultSet.next()) {
					huesped = new Huesped(resultSet.getString("nombre"), resultSet.getString("apellido"),
							resultSet.getDate("fechaNacimiento"), resultSet.getString("nacionalidad"), 
							resultSet.getString("telefono"), idReserva);
				}
				return huesped;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public int editar(Huesped huesped) {
		
		try (final PreparedStatement statement = conexion.prepareStatement(
				"UPDATE huesped SET nombre =?, apellido =?, fechaNacimiento =?, nacionalidad =?, telefono =?  WHERE id_reserva = ?")){
				
			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, huesped.getFechaNacimiento());
			statement.setString(4, huesped.getNacionalidad());
			statement.setString(5, huesped.getTelefono());
			statement.setInt(6, huesped.getId_Reserva());
									
			statement.execute();
			int cant = statement.getUpdateCount(); // cantidad de resultados que fueron actualizados

			return cant;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
}
