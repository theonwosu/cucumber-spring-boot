package com.ttninc.service;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.ttninc.model.Employee;

@Service
@Scope(SCOPE_CUCUMBER_GLUE)
public class EmployeeServiceImpl implements EmployeeService {
	private final RestTemplate restTemplate = new RestTemplate();
	
    private final String SERVER_URL = "http://localhost";
    private final String EMP_ENDPOINT = "/info";
    
    @LocalServerPort
    private int port;	    
    
    public Employee getEmployee() {
    	Employee emp = restTemplate.getForEntity(getEndPoint(), Employee.class).getBody();
        return emp;
    }
    

    public int addEmployee(@RequestBody final Employee employee) {
    	int status = restTemplate.postForEntity(getEndPoint(), employee, Void.class).getStatusCodeValue();
    	return status;
    }    

    @DeleteMapping
    public void removeAllEmployees() {
    	restTemplate.delete(getEndPoint());
    }	
	
    private String getEndPoint() {
        return SERVER_URL + ":" + port + EMP_ENDPOINT;
    } 
    
	@Override
	public void display() {
		System.out.println("--------------------Testing------------------------");
	}

}
