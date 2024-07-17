package com.mathias.employee_management_system.repository;

import com.mathias.employee_management_system.entity.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
