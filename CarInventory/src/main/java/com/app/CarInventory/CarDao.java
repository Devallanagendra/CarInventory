package com.app.CarInventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CarDao {
	
	
	
	private JdbcTemplate jdbcTemplate;

	public CarDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}

	private JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	  public String insertCar(CarPojo car) { 
		  String sql =
	  "insert into cars values('" + car.getMake() + "','" + car.getModel() + "', '" +
	  car.getYear() + "', '" + car.getPrice() +"')";
	  
	  
	  getJdbcTemplate().update(sql);
	  
	  return "Added successfully";
	  }
		
	
	/*
	 * public void insertCar(CarPojo car) { System.out.println("enter method");
	 * 
	 * String insertcar =
	 * "insert into carinvent values('"+car.getMake()+"','"+car.getModel()+"',"+car.
	 * getYear()+")"; System.out.println("jcxxvhbvjh");
	 * jdbcTemplate.update(insertcar);
	 * 
	 * System.out.println("sucess car");
	 * 
	 * }
	 */
	public List<CarPojo> getListofCars() {

		return jdbcTemplate.query("select * from cars", new RowMapper<CarPojo>() {

			public CarPojo mapRow(ResultSet rs, int rowNumber) throws SQLException {
				CarPojo car = new CarPojo();

				car.setMake(rs.getString(1));
				car.setModel(rs.getString(2));
				car.setYear(rs.getInt(3));
				car.setPrice(rs.getInt(4));
				return car;
			}

		});

	}
}
