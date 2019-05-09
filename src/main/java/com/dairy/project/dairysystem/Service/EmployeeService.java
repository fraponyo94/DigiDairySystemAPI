package com.dairy.project.dairysystem.Service;

import com.dairy.project.dairysystem.Repository.EmployeeRepository;
import com.dairy.project.dairysystem.entity.Employee;
import com.dairy.project.dairysystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeesRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    //Save employee
    private void save(Employee employees){
        employeesRepository.save(employees);
    }

    //Find employee by Id
    public Employee findById(String employeeId) throws ResourceNotFoundException{
        Optional<Employee> employee = employeesRepository.findByEmployeeId(employeeId);

        if(employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
        }

    }




    //Update employee
    public Employee saveEmployee(Employee employee,@Nullable  Employee employeeDetails){
        if(employeeDetails == null){
            return employeesRepository.save(employee);

        }else {
            employee.setPassword(employeeDetails.getPassword());
            employee.setRole(employeeDetails.getRole());
            employee.setDateOfEmployment(employeeDetails.getDateOfEmployment());
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPhoneNumber(employeeDetails.getPhoneNumber());
            employee.setDateOfDismissal(employeeDetails.getDateOfDismissal());
            employee.setEnabled(employeeDetails.isEnabled());

            return employeesRepository.save(employee);
        }
    }

    //Remove employee
    public void deleteEmployee(Employee employee){
        employeesRepository.delete(employee);

    }


    //Find all employees
    public List<Employee> findAll() {
        return employeesRepository.findAll();
    }
}
