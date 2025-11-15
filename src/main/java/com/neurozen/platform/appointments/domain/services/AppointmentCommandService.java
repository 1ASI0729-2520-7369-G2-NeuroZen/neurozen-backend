package com.neurozen.platform.appointments.domain.services;

import com.neurozen.platform.appointments.domain.model.aggregates.Appointment;
import com.neurozen.platform.appointments.domain.model.commands.*;

import java.util.Optional;

public interface AppointmentCommandService {

    Long handle(CreateAppointmentCommand command);

    Optional<Appointment> handle(ConfirmAppointmentCommand command);

    Optional<Appointment> handle(StartAppointmentCommand command);

    Optional<Appointment> handle(CompleteAppointmentCommand command);

    void handle(CancelAppointmentCommand command);

    Optional<Appointment> handle(RescheduleAppointmentCommand command);
}

