package com.hotelAlura.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hotelAlura.factory.ConnectionFactory;

public class pruebaUsuario {

	public static void main(String[] args) {

		ConnectionFactory con = new ConnectionFactory();

		Connection conexion = con.conectar();

		try (final PreparedStatement statement = conexion.prepareStatement("select * from usuarios")) {

			try (final ResultSet resultSet = statement.executeQuery()) {
				
				while (resultSet.next()) {
					String st = resultSet.getString("user");
					String st2 = resultSet.getString("password");
					
					System.out.println(st +" "+ st2);
				}
			}

		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
}
