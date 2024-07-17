package com.mathias.employee_management_system.controller;

import com.mathias.employee_management_system.entity.model.Attendance;
import com.mathias.employee_management_system.entity.model.Employee;
import com.mathias.employee_management_system.entity.model.Leave_application;
import com.mathias.employee_management_system.service.AttendanceService;
import com.mathias.employee_management_system.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final EmployeeService employeeService;


    @GetMapping("attendance/mark")
    public String showMarkAttendancePage(Model model) {
        System.out.println("attendance get called");
        model.addAttribute("attendance", new Attendance());
        return "attendancePage";
    }


    @PostMapping("/attendance/tick")
    public String tickAttendance(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee == null) {
            return "redirect:/login";
        }

        Attendance attendance = new Attendance();
        attendance.setDateTime(LocalDateTime.now());
        attendance.setEmployee(employee);
        attendanceService.saveAttendance(attendance);

        model.addAttribute("employee", employee);
        model.addAttribute("message", "Attendance ticked successfully!");

        return "dashboard";
    }
    @GetMapping("/attendance/list")
    public String showAttendanceList(Model model) {
        List<Attendance> attendanceList = attendanceService.getAllAttendances();
        Map<LocalDate, List<Attendance>> attendanceByDate = attendanceList.stream()
                .collect(Collectors.groupingBy(attendance -> attendance.getDateTime().toLocalDate()));

        model.addAttribute("attendanceByDate", attendanceByDate);

        return "attendance_analytics";

    }

//    @PostMapping("/attendance/tick")
//    public String tickAttendance(@RequestParam("employee_id") Long employeeId, Model model) {
//        System.out.println("attendance is ticked");
//        Employee employee = employeeService.getEmployeeById(employeeId);
//        if (employee == null) {
//            model.addAttribute("error", "Employee not found.");
//            return "error";
//        }
//
//        Attendance attendance = new Attendance();
//        attendance.setDateTime(LocalDateTime.now());
//        attendance.setEmployee(employee);
//        attendanceService.saveAttendance(attendance);
//
//        model.addAttribute("employee", employee);
//        model.addAttribute("message", "Attendance ticked successfully!");
//
//        return "dashboard";
//    }



}
