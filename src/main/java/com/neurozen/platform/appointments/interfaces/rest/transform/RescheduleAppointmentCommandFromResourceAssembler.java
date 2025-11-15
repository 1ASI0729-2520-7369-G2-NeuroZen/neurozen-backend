package com.neurozen.platform.appointments.interfaces.rest.transform;

import com.neurozen.platform.appointments.domain.model.commands.RescheduleAppointmentCommand;
import com.neurozen.platform.appointments.domain.model.valueobjects.AppointmentDateTime;
import com.neurozen.platform.appointments.interfaces.rest.resources.RescheduleAppointmentResource;

public class RescheduleAppointmentCommandFromResourceAssembler {

    public static RescheduleAppointmentCommand toCommandFromResource(Long appointmentId, RescheduleAppointmentResource resource) {
        return new RescheduleAppointmentCommand(
                appointmentId,
                new AppointmentDateTime(resource.newDateTime())
        );
    }
}

