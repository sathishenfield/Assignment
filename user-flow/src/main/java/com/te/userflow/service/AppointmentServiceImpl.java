package com.te.userflow.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.userflow.dto.AppointmentDTO;
import com.te.userflow.dto.AppointmentResponse;
import com.te.userflow.entity.Appointment;
import com.te.userflow.entity.Doctor;
import com.te.userflow.entity.User;
import com.te.userflow.exception.AppointmentAlreadyBookedException;
import com.te.userflow.exception.DoctorNotFoundException;
import com.te.userflow.repository.AppointmentDAO;
import com.te.userflow.repository.DoctorDAO;
import com.te.userflow.repository.UserDAO;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDAO appointmentDAO;

	@Autowired
	private DoctorDAO doctorDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AppointmentResponse bookAppointment(AppointmentDTO appointmentDTO, Integer doctorId, String userName) {

		User user = userDAO.findByName(userName);
		Optional<Doctor> findById = doctorDAO.findById(doctorId);

		Appointment appointment = dtoToEntityConverter(appointmentDTO);
		appointment.setUser(user);
		if (!findById.isEmpty()) {
			Doctor doctor = findById.get();
			Boolean checkingAppointment = checkingAppointment(doctor, appointmentDTO);
			if (checkingAppointment) {
				appointment.setDoctor(doctor);
				Appointment save = appointmentDAO.save(appointment);
				AppointmentResponse map = mapper.map(save, AppointmentResponse.class);
				return map;
			} else {
				throw new AppointmentAlreadyBookedException("Change Booking time");
			}

		} else {
			throw new DoctorNotFoundException("Doctor Not found");
		}
	}

	private Appointment dtoToEntityConverter(AppointmentDTO appointmentDTO) {

		Appointment appointment = mapper.map(appointmentDTO, Appointment.class);
		return appointment;
	}

	private Boolean checkingAppointment(Doctor doctor, AppointmentDTO appointmentDTO) {

		Boolean result = false;

		List<Appointment> appointments = doctor.getAppointments();
		for (Appointment appointment : appointments) {
			if (appointment.getBookingDate().compareTo(appointmentDTO.getBookingDate()) == 0) {
				if (appointment.getBookingTime().compareTo(appointmentDTO.getBookingTime()) != 0) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = true;
			}
		}

		return result;

	}

}
