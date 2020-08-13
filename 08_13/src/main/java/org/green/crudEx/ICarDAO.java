package org.green.crudEx;

import java.sql.Connection;

public interface ICarDAO {
	Connection connect();
	void disconnect(Connection con);
	int insertCar(Connection con, Car car);
	Car[] getAll(Connection con);
}
