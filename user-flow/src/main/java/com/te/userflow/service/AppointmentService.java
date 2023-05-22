package com.te.userflow.service;

import com.te.userflow.dto.AppointmentDTO;
import com.te.userflow.dto.AppointmentResponse;

public interface AppointmentService {

	public AppointmentResponse bookAppointment(AppointmentDTO appointmentDTO, Integer doctorId, String userName);

}
