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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public String listOfEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "create_employee";
    }
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("employees/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";
    }

    @PostMapping("employees/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());
        employeeService.saveEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);

        return "redirect:/employees";
    }

    @GetMapping("/profile")
    public String getProfile( Model model, HttpSession session) {
        Employee sessionEmployee = (Employee) session.getAttribute("employee");
        System.out.println("Session Employee: " + sessionEmployee);
        if (sessionEmployee == null) {
            System.out.println("Redirecting to login: Employee not in session or ID does not match");
            return "redirect:/login";
        }
        Long id = sessionEmployee.getId();
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println("Fetched Employee: " + employee);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "profile";
        } else {
            System.out.println("Redirecting to dashboard: Employee not found");
            return "redirect:/dashboard";
        }
    }
}
