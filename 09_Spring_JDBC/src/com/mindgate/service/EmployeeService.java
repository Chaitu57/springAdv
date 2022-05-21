package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mindgate.dao.EmployeeDAoInterface;
import com.mindgate.pojo.Employee;


@Service("employeeService")
@Scope("prototype")
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeDAoInterface employeeDAoInterface;
	
	@Override
	public boolean addNewEmployee(Employee employee) {
		System.out.println("inside EmployeeService addNewEmployee");
		return employeeDAoInterface.addNewEmployee(employee);
	}

	@Override
	public List<Employee> getallEmployee() {
		// TODO Auto-generated method stub
		return  employeeDAoInterface.getallEmployee();
	}

	@Override
	public Employee getemEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDAoInterface.getemEmployeeByEmployeeId(employeeId);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAoInterface.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		return employeeDAoInterface.deleteEmployeeByEmployeeId(employeeId);
	}

}
