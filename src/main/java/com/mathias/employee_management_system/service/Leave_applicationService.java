package com.mathias.employee_management_system.service;

import com.mathias.employee_management_system.entity.model.Employee;
import com.mathias.employee_management_system.entity.model.Leave_application;

import java.util.List;

public interface Leave_applicationService {
    List<Leave_application> getAllLeaveApplications();
    Leave_application saveLeaveApplication(Leave_application leave_application);
    Leave_application getLeaveApplicationById(Long id);
    void deleteLeaveApplicationById(Long id);
    List<Leave_application> getLeaveApplicationsByEmployeeId(Long employeeId);
    List<Leave_application> findByEmployee(Employee employee);
}
