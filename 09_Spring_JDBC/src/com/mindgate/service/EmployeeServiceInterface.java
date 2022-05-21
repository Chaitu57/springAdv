package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.Employee;

public interface EmployeeServiceInterface {
	public boolean addNewEmployee(Employee employee);

	public List<Employee> getallEmployee();

	public Employee getemEmployeeByEmployeeId(int employeeId);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployeeByEmployeeId(int employeeId);
}
