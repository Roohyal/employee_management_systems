package com.mathias.employee_management_system.repository;

import com.mathias.employee_management_system.entity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
