package com.mathias.employee_management_system.repository;

import com.mathias.employee_management_system.entity.model.Employee;
import com.mathias.employee_management_system.entity.model.Leave_application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave_application , Long> {

    List<Leave_application> findByEmployeeId(Long employeeId);

    List<Leave_application> findByEmployee(Employee employee);
}
