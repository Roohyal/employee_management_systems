package com.mathias.employee_management_system.controller;

import com.mathias.employee_management_system.entity.enums.Status;
import com.mathias.employee_management_system.entity.model.Employee;
import com.mathias.employee_management_system.entity.model.Leave_application;
import com.mathias.employee_management_system.repository.LeaveRepository;
import com.mathias.employee_management_system.service.EmployeeService;
import com.mathias.employee_management_system.service.Leave_applicationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LeaveController {

    public final Leave_applicationService leaveService;
    public final EmployeeService employeeService;

    @GetMapping("/leave/apply")
    public String showLeaveForm(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee == null) {
            return "redirect:/login";
        }
        model.addAttribute("leaveApplication", new Leave_application());
        return "leaveApplicationForm";
    }

    @PostMapping("/leave/apply")
    public String applyLeave(@ModelAttribute Leave_application  leaveApplication, HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee == null) {
            return "redirect:/login";
        }

        leaveApplication.setEmployee(employee);
        leaveApplication.setStatus(Status.PENDING);
        leaveService.saveLeaveApplication(leaveApplication);

        model.addAttribute("employee", employee);
        model.addAttribute("message", "Leave application submitted successfully!");
        return "dashboard";
    }
    @GetMapping("/leave/lists")
    public String listLeaves(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee == null) {
            return "redirect:/login";
        }
        model.addAttribute("employees",leaveService.findByEmployee(employee));
        System.out.println("The First Name is " + employee.getFirstName());
        model.addAttribute("leaves", leaveService.getAllLeaveApplications());
        model.addAttribute("statuses",Status.values());
        return "adminViewList";
    }
    @PostMapping("/leave/update/{id}")
    public String updateLeaveStatus(@PathVariable Long id, @RequestParam Status status, Leave_application leave) {
        Leave_application existingLeave = leaveService.getLeaveApplicationById(id);

        if (existingLeave != null) {
            existingLeave.setStatus(leave.getStatus());

            leaveService.saveLeaveApplication(existingLeave);
        } else {
            // Handle case where leave with given ID is not found
            throw new RuntimeException("Leave request not found with id: " + id);
        }
        return "redirect:/leave/lists";
    }

    @GetMapping("/leave/delete/{id}")
    public String deleteLeave(@PathVariable("id") Long id) {
        leaveService.deleteLeaveApplicationById(id);
        return "redirect:/leave/list";
    }
    @GetMapping("/leave/list")
    public String listOfYourLeaves(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Long id = employee.getId();
        System.out.println("The id of the leave application is " + id);
        model.addAttribute("leaves", leaveService.getLeaveApplicationsByEmployeeId(id));

        return "employeeViewList";
    }


}
