package com.neurozen.platform.appointments.interfaces.rest.transform;

import com.neurozen.platform.appointments.domain.model.commands.CreateAppointmentCommand;
import com.neurozen.platform.appointments.domain.model.valueobjects.AppointmentDateTime;
import com.neurozen.platform.appointments.domain.model.valueobjects.EmployeeId;
import com.neurozen.platform.appointments.domain.model.valueobjects.PsychologistId;
import com.neurozen.platform.appointments.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResourceAssembler {

    public static CreateAppointmentCommand toCommandFromResource(CreateAppointmentResource resource) {
        return new CreateAppointmentCommand(
                new EmployeeId(resource.employeeId()),
                new PsychologistId(resource.psychologistId()),
                new AppointmentDateTime(resource.appointmentDateTime())
        );
    }
}

