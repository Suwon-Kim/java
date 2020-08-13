package org.green.crudEx;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	private ICarDAO dao;
	
	public Car[] getAll() {
		Connection con = dao.connect();
		Car[] list = dao.getAll(con);
		dao.disconnect(con);
		return  list;
	}
	
	public int insertCar(Car car) {
		Connection con = dao.connect();
		int result = dao.insertCar(con, car);
		dao.disconnect(con);
		return result;
	}
}




