package com.ttninc.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.ttninc.model.Employee;

public interface EmployeeService {
	public Employee getEmployee();
	public int addEmployee(@RequestBody final Employee employee);
	public void removeAllEmployees();
	public void display();
}
