package com.neurozen.platform.appointments.interfaces.rest.resources;

import java.time.LocalDateTime;

public record RescheduleAppointmentResource(LocalDateTime newDateTime) {
}

