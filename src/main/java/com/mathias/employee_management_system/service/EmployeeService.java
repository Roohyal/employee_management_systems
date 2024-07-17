package com.mathias.employee_management_system.service;

import com.mathias.employee_management_system.entity.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee findByEmail(String email);
}
