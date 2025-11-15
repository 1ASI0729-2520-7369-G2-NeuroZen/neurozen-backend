package com.neurozen.platform.appointments.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateAppointmentResource(
        Long employeeId,
        Long psychologistId,
        LocalDateTime appointmentDateTime
) {
}

