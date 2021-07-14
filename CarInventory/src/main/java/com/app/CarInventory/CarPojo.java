package com.app.CarInventory;

import java.util.List;

public class CarPojo {
	
	   private String Make;
	   private String Model;  
	   private Integer Year;  
	   private Integer Price;
	String getMake() {
		return Make;
	}
	void setMake(String make) {
		Make = make;
	}
	String getModel() {
		return Model;
	}
	void setModel(String model) {
		Model = model;
	}
	Integer getYear() {
		return Year;
	}
	void setYear(Integer year) {
		Year = year;
	}
	Integer getPrice() {
		return Price;
	}
	void setPrice(Integer price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "CarPojo [Make=" + Make + ", Model=" + Model + ", Year=" + Year + ", Price=" + Price + "]";
	}
	
	   
}
