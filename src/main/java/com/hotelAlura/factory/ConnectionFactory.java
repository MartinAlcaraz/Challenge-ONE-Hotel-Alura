package com.hotelAlura.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;
	
	public ConnectionFactory() {							//	 la dependencia cp30 provee este metodo.
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource(); // com.mchange.v2.c3p0.ComboPooledDataSource.ComboPooledDataSource()
		
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("root1234");
		pooledDataSource.setMaxPoolSize(10);  // maximo de conexiones que se mantendrán abiertas de esta forma se evita que se sature la base de datos.
		this.dataSource = pooledDataSource;
	}									
	
	public Connection conectar() {
		try {
			return  this.dataSource.getConnection(); // se obtiene una conexion del pool de conexiones
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}  
	}
	
}
