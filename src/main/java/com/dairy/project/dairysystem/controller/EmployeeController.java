package com.dairy.project.dairysystem.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.dairy.project.dairysystem.Repository.EmployeeRepository;
import com.dairy.project.dairysystem.Service.EmployeeService;
import com.dairy.project.dairysystem.entity.Employee;
import com.dairy.project.dairysystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/dairy/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") String employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeService.findById(employeeId);
		return ResponseEntity.ok().body(employee);
	}

	//Save employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {

		return employeeService.saveEmployee(employee,null);
	}

	//Update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeService.findById(employeeId);

		final Employee updatedEmployee = employeeService.saveEmployee(employee,employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
	}


   //delete employee
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeService.findById(employeeId);

		employeeService.deleteEmployee(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
