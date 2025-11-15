package com.neurozen.platform.appointments.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public record EmployeeId(@Column(name = "employee_id") Long employeeId) {
    public EmployeeId {
        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be a positive number");
        }
    }
}

