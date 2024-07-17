package com.mathias.employee_management_system.service.impl;

import com.mathias.employee_management_system.entity.model.Employee;
import com.mathias.employee_management_system.repository.EmployeeRepository;
import com.mathias.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
 @Autowired


 EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
   public void  deleteEmployee (Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByEmail(String email) {
      return employeeRepository.findByEmail(email);
    }
}
