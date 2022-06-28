package com.hotelAlura.tests;

import java.sql.Connection;
import java.sql.SQLException;

import com.hotelAlura.factory.ConnectionFactory;

public class pruebaConexion {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conexion = new ConnectionFactory();
		
		Connection con= conexion.conectar();
		
		con.close();
		System.out.println("cerrando conexion");
		
		
	}
}
