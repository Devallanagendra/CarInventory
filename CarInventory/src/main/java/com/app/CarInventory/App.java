package com.app.CarInventory;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		CarDao dao = context.getBean("carDao", CarDao.class);
		
		System.out.println("Welcome to Mullet Joe's Gently Used Autos!");

		CarPojo pj = new CarPojo();

		System.out.println("Enter Command");
		Scanner scanner = new Scanner(System.in);
		String cmd = scanner.nextLine();
		if (cmd.toLowerCase().equals("add")) {

			System.out.println("Plz Enter Make:");
			String make = scanner.nextLine();
			pj.setMake(make);

			System.out.println("plz Enter Mode:");
			String model = scanner.nextLine();
			pj.setModel(model);

			System.out.println("plz Enter Year");
			int year = scanner.nextInt();
			pj.setYear(year);

			System.out.println("Plz Enter SalesPrize:");
			int price = scanner.nextInt();
			pj.setPrice(price);
			
			dao.insertCar(pj);
			

		} else if (cmd.toLowerCase().equals("list")) {
			List<CarPojo> list = dao.getListofCars();

			if (list.size() > 0) {
				list.forEach(carlist -> System.out.println(carlist));
				System.out.println("Numbers of cars :" + list.size());
				double listOfPrice = list.stream().mapToDouble(listPrice -> listPrice.getPrice()).sum();
				String sql = "select * from cars";
				
			} else {
				System.out.println("There  are  no cares");
			}

		} else if (cmd.toLowerCase().equals("quit")) {
			System.out.println("Good Bye");
		} else {
			System.out.println(cmd  +" :"+ "Not valid plz enter valid commend like Add or list or quit ");
		}

	}

}
