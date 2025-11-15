package com.neurozen.platform.appointments.interfaces.rest.transform;

import com.neurozen.platform.appointments.domain.model.aggregates.Appointment;
import com.neurozen.platform.appointments.interfaces.rest.resources.AppointmentResource;

public class AppointmentResourceFromEntityAssembler {

    public static AppointmentResource toResourceFromEntity(Appointment entity) {
        return new AppointmentResource(
                entity.getId(),
                entity.getEmployeeId().employeeId(),
                entity.getPsychologistId().psychologistId(),
                entity.getAppointmentDateTime().dateTime(),
                entity.getStatus(),
                entity.getNotes(),
                entity.getCancellationReason()
        );
    }
}

