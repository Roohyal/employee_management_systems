package com.mathias.employee_management_system.entity.model;

import com.mathias.employee_management_system.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee_leave")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Leave_application {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate start_date;
    private LocalDate end_date;
    private String reason;

    @Enumerated (EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
