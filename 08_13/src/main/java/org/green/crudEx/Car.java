package org.green.crudEx;

public class Car {
	private int car_id;
	private String car_model;
	private int car_price;
	private String car_desc;
	
	public Car() {
	} 
	
	public Car(int car_id, String car_model, int car_price, String car_desc) {
		super();
		this.car_id = car_id;
		this.car_model = car_model;
		this.car_price = car_price;
		this.car_desc = car_desc;
	}
	
	public Car(String car_model, int car_price, String car_desc) {
		super();
		this.car_model = car_model;
		this.car_price = car_price;
		this.car_desc = car_desc;
	}
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public int getCar_price() {
		return car_price;
	}
	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}
	public String getCar_desc() {
		return car_desc;
	}
	public void setCar_desc(String car_desc) {
		this.car_desc = car_desc;
	}
	
	
}
