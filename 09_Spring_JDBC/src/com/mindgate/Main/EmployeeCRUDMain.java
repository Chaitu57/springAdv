package com.mindgate.Main;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindgate.config.ApplicationConfig;
import com.mindgate.dao.EmployeeDAoInterface;
import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeCRUDMain {

	public static void main(String[] args) {
		Employee employee = new Employee(1, "chaitanya", 100);

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		EmployeeServiceInterface employeeServiceInterface = applicationContext.getBean("employeeService",
				EmployeeService.class);

		boolean result = employeeServiceInterface.addNewEmployee(employee);
		if (result) {
			System.out.println("Employee added sucessfully");
		} else {
			System.out.println("failed sucessfully");
		}

		List<Employee> allEmployees = employeeServiceInterface.getallEmployee();

		for (Employee emp : allEmployees) {
			System.out.println(emp);
		}

		System.out.println("-".repeat(50));

		Employee chaitanya = employeeServiceInterface.getemEmployeeByEmployeeId(1);
		System.out.println(chaitanya);

		System.out.println("-".repeat(60));

		Employee emp = new Employee(1, "santosh", 6000);
		boolean result1 = employeeServiceInterface.updateEmployee(emp);
		if (result1) {
			System.out.println("Employee updated sucessfully");
		} else {
			System.out.println("failed to update employee");
		}

	}

}
