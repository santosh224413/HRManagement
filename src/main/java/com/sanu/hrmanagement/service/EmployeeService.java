package com.sanu.hrmanagement.service;

import com.sanu.hrmanagement.exception.UserNotFoundException;
import com.sanu.hrmanagement.model.Employee;
import com.sanu.hrmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();

            //Update the employee fields if provided
            if (employee.getName() != null) {
                existingEmployee.setName(employee.getName());
            }
            if(employee.getEmail() !=null){
                existingEmployee.setEmail(employee.getEmail());
            }
            if(employee.getJobTitle() != null){
                existingEmployee.setJobTitle(employee.getJobTitle());
            }
            if(employee.getPhoneNumber() !=null){
                existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            }
            if(employee.getImageURL() !=null){
                existingEmployee.setImageURL(employee.getImageURL());
            }
            return employeeRepository.save(existingEmployee);
        } else{
            return null;
        }
    }
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with the id " + id + "Not found")
        );
    }
    public void deleteEmployee(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            throw new UserNotFoundException("User with the id " + id + "does not exists");
        } else {
            employeeRepository.deleteById(id);
        }

    }

}
