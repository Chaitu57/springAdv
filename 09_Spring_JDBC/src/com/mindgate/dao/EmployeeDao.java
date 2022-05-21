package com.mindgate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.Employee;
import com.mindgate.rowMappper.EmployeeRowMapper;

@Repository
@Scope("prototype")
public class EmployeeDao implements EmployeeDAoInterface {
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_EMPLOYEE = "INSERT INTO employee_details(name,salary) values(?,?)";
	private static final String SELECT_ALL_EMPLOYEE = "select*from employee_details";
	private static final String SELECT_SINGLE_EMPLOYEE = "select*from employee_details where employee_id=?";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details set name=?,salary=? where employee_id=?";
	private static final String DELETE_EMPLOYEE = "DELETE employee_details where employeeId=?";
	
	private int resultcount;

	public EmployeeDao() {

	}

	@Autowired
	public EmployeeDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addNewEmployee(Employee employee) {

		System.out.println("inserting new employee to database");
		System.out.println(employee);
		Object[] args = { employee.getName(), employee.getSalary() };

		resultcount = jdbcTemplate.update(INSERT_EMPLOYEE, args);

		if (resultcount > 0)
			return true;
		else

			return false;
	}

	@Override
	public List<Employee> getallEmployee() {
            List<Employee>allemployees= jdbcTemplate.query(SELECT_ALL_EMPLOYEE, new EmployeeRowMapper());
		return allemployees;
	}

	@Override
	public Employee getemEmployeeByEmployeeId(int employeeId) {
  Object[] args= {employeeId};
  Employee employee=jdbcTemplate.queryForObject(SELECT_SINGLE_EMPLOYEE, args, new EmployeeRowMapper());
		
		return employee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Object[] args = { employee.getName(), employee.getSalary(),employee.getEmployeeId() };

		resultcount = jdbcTemplate.update(UPDATE_EMPLOYEE, args);

		if (resultcount > 0)
			return true;
		else

			return false;
		
		

	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {

		Object[] args = { employeeId };

		resultcount = jdbcTemplate.update(DELETE_EMPLOYEE, args);

		if (resultcount > 0)
			return true;
		else

			return false;
		
		
		
	
	}

}
