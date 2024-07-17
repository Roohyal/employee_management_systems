package com.mathias.employee_management_system.service.impl;

import com.mathias.employee_management_system.entity.model.Attendance;
import com.mathias.employee_management_system.repository.AttendanceRepository;
import com.mathias.employee_management_system.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private final AttendanceRepository attendanceRepository;



    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).get();
    }
}
