package co.alpha.controller;

import co.alpha.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		Long id = employeeService.add();
		System.out.println("id is" + id);
	}

}
