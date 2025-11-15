package com.neurozen.platform.appointments.infrastructure.persistence.jpa.repositories;

import com.neurozen.platform.appointments.domain.model.aggregates.Appointment;
import com.neurozen.platform.appointments.domain.model.valueobjects.EmployeeId;
import com.neurozen.platform.appointments.domain.model.valueobjects.PsychologistId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByEmployeeId(EmployeeId employeeId);

    List<Appointment> findByPsychologistId(PsychologistId psychologistId);
}

