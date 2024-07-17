package com.mathias.employee_management_system.controller;

import com.mathias.employee_management_system.entity.model.Employee;
import com.mathias.employee_management_system.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    public  final EmployeeService employeeService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "login";
    }
    @PostMapping("/login")
        public String LoginUser(@ModelAttribute("employee") Employee employee,Model model, HttpSession session) {
        Employee existingEmployee = employeeService.findByEmail(employee.getEmail());
        String imageUrl = "/images/management.jpeg";
        if (existingEmployee != null && existingEmployee.getPassword().equals(employee.getPassword())) {
            session.setAttribute("employee", existingEmployee);
            if(existingEmployee.getEmail().endsWith("@admin.com")){
                model.addAttribute("employees", existingEmployee);
                model.addAttribute("ImageUrl", imageUrl);
                return "adminDashboard";
            } else {
                model.addAttribute("employee", existingEmployee);
                model.addAttribute("ImageUrl",imageUrl);
                return "dashboard";
            }
        }else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
    @GetMapping("/dashboard")
    public String redirectToDashboard(HttpSession session,  Model model) {
        Employee existingemployee = (Employee) session.getAttribute("employee");
        String imageUrl = "/images/management.jpeg";
        if (existingemployee == null) {
            return "redirect:/login";
        }
        model.addAttribute("employee", existingemployee);
        model.addAttribute("ImageUrl", imageUrl);
        return "dashboard";
    }
    @GetMapping("/adminDashboard")
    public String redirectToAdminDashboard(HttpSession session,Model model) {
        String imageUrl = "/images/management.jpeg";
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee == null) {
            return "redirect:/login";
        }
        model.addAttribute("employee", employee);
        model.addAttribute("ImageUrl",imageUrl);
        return "adminDashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session, effectively logging out the admin
        return "redirect:/login"; // Redirect to the sign-in page after logout
    }
}
