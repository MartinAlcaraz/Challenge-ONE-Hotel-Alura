package com.hotelAlura.controller;

import java.sql.Connection;
import java.util.List;

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
	
	public List<Reserva> listaReservas(){
		return reservaDao.listaReservas();
	}
	
	public int eliminar(int idReserva) {
		return reservaDao.eliminar(idReserva);
	}

	public int editar(Reserva reserva) {
		return reservaDao.editarReserva(reserva);
	}

	public Reserva getReserva(int idReserva) {
		return reservaDao.getReserva(idReserva);
	}
	
}
