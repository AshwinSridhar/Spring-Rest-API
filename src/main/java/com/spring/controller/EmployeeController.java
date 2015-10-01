package com.spring.controller;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Employee;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@RequestMapping(method=RequestMethod.GET ,produces="application/json", value="/hello.json")
	public List<Employee> getEmployeeJson(){
		
		return getEmployee();
		
	}
	
	@RequestMapping(method=RequestMethod.GET ,produces="application/xml", value="/hello.xml")
	public List<Employee> getEmployeeXml(){
		
		return getEmployee();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update")
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody Employee update(@RequestBody Employee emp){
		// Some DB Operation to Update the database
		System.out.println( emp.getName());
		return emp;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	@ResponseStatus(value=HttpStatus.CREATED)
	public @ResponseBody Employee create(@RequestBody Employee emp){
		// Some DB Operation to create an Employee
		System.out.println(emp.getName());
		return emp;
	}
	
	public List<Employee> getEmployee(){
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("x");
		
		Employee emp1 = new Employee();
		emp1.setId(2);
		emp1.setName("y");
		
		List<Employee> res = new ArrayList<Employee>();
		res.add(emp);
		res.add(emp1);
		
		return res;
	}
	
}
