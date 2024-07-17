package com.mathias.employee_management_system.service;

import com.mathias.employee_management_system.entity.model.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance saveAttendance(Attendance attendance);

    List<Attendance> getAllAttendances();

    Attendance getAttendanceById(Long id);
}
