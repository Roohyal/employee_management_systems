package com.mathias.employee_management_system.service.impl;

import com.mathias.employee_management_system.entity.model.Employee;
import com.mathias.employee_management_system.entity.model.Leave_application;
import com.mathias.employee_management_system.repository.LeaveRepository;
import com.mathias.employee_management_system.service.Leave_applicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LeaveApplicationServiceImpl implements Leave_applicationService {
 private final LeaveRepository leaveRepository;
    @Override
    public List<Leave_application> getAllLeaveApplications() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave_application saveLeaveApplication(Leave_application leave_application) {
        return leaveRepository.save(leave_application);
    }

    @Override
    public Leave_application getLeaveApplicationById(Long id) {
        return leaveRepository.findById(id).get();
    }

    @Override
    public void deleteLeaveApplicationById(Long id) {
        leaveRepository.deleteById(id);
    }

    @Override
    public List<Leave_application> getLeaveApplicationsByEmployeeId(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Leave_application> findByEmployee(Employee employee) {
        return leaveRepository.findByEmployee(employee);
    }


}
