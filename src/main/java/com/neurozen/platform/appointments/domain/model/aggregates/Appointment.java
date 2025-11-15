package com.neurozen.platform.appointments.domain.model.aggregates;

import com.neurozen.platform.appointments.domain.model.valueobjects.AppointmentDateTime;
import com.neurozen.platform.appointments.domain.model.valueobjects.AppointmentStatus;
import com.neurozen.platform.appointments.domain.model.valueobjects.EmployeeId;
import com.neurozen.platform.appointments.domain.model.valueobjects.PsychologistId;
import com.neurozen.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class Appointment extends AuditableAbstractAggregateRoot<Appointment> {
    
    @Embedded
    private EmployeeId employeeId;
    
    @Embedded
    private PsychologistId psychologistId;
    
    @Embedded
    private AppointmentDateTime appointmentDateTime;
    
    @Column(length = 1000)
    private String notes;
    
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    
    @Column(length = 500)
    private String cancellationReason;

    public Appointment() {
        super();
        this.status = AppointmentStatus.SCHEDULED;
    }

    public Appointment(EmployeeId employeeId, PsychologistId psychologistId, AppointmentDateTime appointmentDateTime) {
        this();
        this.employeeId = employeeId;
        this.psychologistId = psychologistId;
        this.appointmentDateTime = appointmentDateTime;
    }

    public void confirm() {
        if (this.status == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("Cannot confirm a cancelled appointment");
        }
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void start() {
        if (this.status != AppointmentStatus.CONFIRMED && this.status != AppointmentStatus.SCHEDULED) {
            throw new IllegalStateException("Appointment must be confirmed or scheduled to start");
        }
        this.status = AppointmentStatus.IN_PROGRESS;
    }

    public void complete(String notes) {
        if (this.status != AppointmentStatus.IN_PROGRESS) {
            throw new IllegalStateException("Appointment must be in progress to be completed");
        }
        this.status = AppointmentStatus.COMPLETED;
        this.notes = notes;
    }

    public void cancel(String reason) {
        if (this.status == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Cannot cancel a completed appointment");
        }
        this.status = AppointmentStatus.CANCELLED;
        this.cancellationReason = reason;
    }

    public void markAsNoShow() {
        if (this.status == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Cannot mark a completed appointment as no show");
        }
        this.status = AppointmentStatus.NO_SHOW;
    }

    public void reschedule(AppointmentDateTime newDateTime) {
        if (this.status == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Cannot reschedule a completed appointment");
        }
        if (this.status == AppointmentStatus.CANCELLED) {
            throw new IllegalStateException("Cannot reschedule a cancelled appointment");
        }
        this.appointmentDateTime = newDateTime;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public void updateNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return this.status.name().toLowerCase();
    }
}

