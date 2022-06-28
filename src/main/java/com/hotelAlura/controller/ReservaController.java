package com.hotelAlura.controller;

import java.sql.Connection;
import com.hotelAlura.dao.ReservaDAO;
import com.hotelAlura.factory.ConnectionFactory;
import com.hotelAlura.model.Reserva;

public class ReservaController {

	private ReservaDAO reservaDao;
	
	public ReservaController(){
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexion = factory.conectar();
		this.reservaDao = new ReservaDAO(conexion);
	}
	
	public int reservar(Reserva reserva){
		return reservaDao.reservar(reserva);
	}
	
	public void eliminarReserva(int idReserva) {
		reservaDao.eliminarReserva(idReserva);
	}
}
