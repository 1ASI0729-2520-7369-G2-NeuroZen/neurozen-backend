package com.neurozen.platform.appointments.domain.services;

import com.neurozen.platform.appointments.domain.model.aggregates.Appointment;
import com.neurozen.platform.appointments.domain.model.queries.GetAllAppointmentsByEmployeeIdQuery;
import com.neurozen.platform.appointments.domain.model.queries.GetAllAppointmentsByPsychologistIdQuery;
import com.neurozen.platform.appointments.domain.model.queries.GetAllAppointmentsQuery;
import com.neurozen.platform.appointments.domain.model.queries.GetAppointmentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {

    Optional<Appointment> handle(GetAppointmentByIdQuery query);

    List<Appointment> handle(GetAllAppointmentsQuery query);

    List<Appointment> handle(GetAllAppointmentsByEmployeeIdQuery query);

    List<Appointment> handle(GetAllAppointmentsByPsychologistIdQuery query);
}

