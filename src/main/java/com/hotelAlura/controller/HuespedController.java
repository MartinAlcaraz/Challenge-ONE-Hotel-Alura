package com.hotelAlura.controller;

import java.sql.Connection;

import com.hotelAlura.dao.HuespedDAO;
import com.hotelAlura.factory.ConnectionFactory;
import com.hotelAlura.model.Huesped;

public class HuespedController {

	private HuespedDAO huespedDao;
	
	public HuespedController(){
		ConnectionFactory factory = new ConnectionFactory();
		Connection conexion = factory.conectar();
		this.huespedDao = new HuespedDAO(conexion);
	}

	public void registrar(Huesped huesped) {
		huespedDao.registrar(huesped);
	}
}
