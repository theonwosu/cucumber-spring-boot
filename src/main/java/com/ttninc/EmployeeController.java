package com.ttninc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ttninc.model.Employee;

@RestController
@RequestMapping("/info")
public final class EmployeeController {
	private List<Employee> list = new ArrayList<>();

    @GetMapping
    public Employee getEmployee() {
    	Employee emp = new Employee();
    	emp.setName("Joe");
    	emp.setAge(50);
    	list.add(emp);
        return emp;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody final Employee employee) {
    	list.add(employee);
        System.out.println("--------Good job!!!!!-------------");
        System.out.println(employee);
    }    

    @DeleteMapping
    public void removeAllEmployees() {
    	System.out.println(">>>>>>>>>>>>>>>>Initial size: "+list.size());
        list.clear();
        System.out.println(">>>>>>>>>>>>>>>>Final size: "+list.size());
    }
}
