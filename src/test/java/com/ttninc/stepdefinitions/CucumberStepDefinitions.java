package com.ttninc.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import com.ttninc.CucumberSpringBootApplication;
import com.ttninc.model.Employee;
import com.ttninc.service.EmployeeService;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CucumberSpringBootApplication.class)
public class CucumberStepDefinitions {
	private static final Logger LOG = LoggerFactory.getLogger(CucumberStepDefinitions.class);

	@LocalServerPort
	private int port;

	@Autowired
	private EmployeeService employeeService;

	@Before
	public void setUp() {
		LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
		employeeService.display();
	}

	@Given("^the user can access employee$")
	public void the_user_can_access_employee() {
		Employee emp = employeeService.getEmployee();
		System.out.println("Using the service to retrieve employee");
		System.out.println(emp);
	}

	@When("^the user adds an employee$")
	public void the_user_adds_an_employee() {
		Employee employee = new Employee();
		employee.setName("Mary");
		employee.setAge(65);
		int status = employeeService.addEmployee(employee);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>Status : " + status + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	@And("^the user can clear employee list$")
	public void the_user_can_clear_employee_list() {
		employeeService.removeAllEmployees();
	}

}
