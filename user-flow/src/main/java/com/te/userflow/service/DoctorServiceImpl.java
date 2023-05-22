package com.te.userflow.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.userflow.dto.AppointmentDTO;
import com.te.userflow.dto.DoctorDTO;
import com.te.userflow.dto.DoctorWithAppointment;
import com.te.userflow.entity.Appointment;
import com.te.userflow.entity.Doctor;
import com.te.userflow.exception.DoctorNotFoundException;
import com.te.userflow.repository.DoctorDAO;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDAO doctorDAO;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<DoctorDTO> getDoctorByName(String name) {

		List<Doctor> findByName = doctorDAO.findByName(name);
		List<DoctorDTO> doctors = dtoToEntityConverter(findByName);
		if (!doctors.isEmpty()) {

			return doctors;
		} else {
			throw new DoctorNotFoundException("Doctor Not Found");
		}
	}

	@Override
	public List<DoctorDTO> getAllDoctor() {

		List<Doctor> findAll = doctorDAO.findAll();
		return dtoToEntityConverter(findAll);
	}

	private List<DoctorDTO> dtoToEntityConverter(List<Doctor> doctors) {

		List<DoctorDTO> doctorDTOs = new ArrayList<>();

		doctors.forEach(i -> {
			DoctorDTO map = mapper.map(i, DoctorDTO.class);
			doctorDTOs.add(map);
		});
		return doctorDTOs;
	}

	@Override
	public List<DoctorWithAppointment> getDoctorWithAppointment(String doctorName) {
		List<Doctor> doctors = doctorDAO.findByName(doctorName);

		List<DoctorWithAppointment> doctorWithAppointments = new ArrayList<>();
		List<AppointmentDTO> todayList = new ArrayList<>();
		List<AppointmentDTO> tomorrowList = new ArrayList<>();
		if (!doctors.isEmpty()) {
			for (Doctor doctor : doctors) {
				DoctorWithAppointment withAppointment = new DoctorWithAppointment();
				withAppointment.setName(doctor.getName());
				withAppointment.setMobNo(doctor.getMobNo());
				withAppointment.setSpecialization(doctor.getSpecialization());	
				List<Appointment> appointments = doctor.getAppointments();
				List<AppointmentDTO> appointmentDTOs = new ArrayList<>();
				for (Appointment appointment : appointments) {
					AppointmentDTO map = mapper.map(appointment, AppointmentDTO.class);
					appointmentDTOs.add(map);
				}
				for (AppointmentDTO appointmentDTO : appointmentDTOs) {
					if (appointmentDTO.getBookingDate().equals(LocalDate.now())) {
						todayList.add(appointmentDTO);
						withAppointment.setTodayList(todayList);

					} else if (appointmentDTO.getBookingDate().equals(LocalDate.now().plusDays(1))) {
						tomorrowList.add(appointmentDTO);
						withAppointment.setTommorrowList(tomorrowList);
					}
				}

				todayList.sort(Comparator.comparing(AppointmentDTO::getBookingDate)
						.thenComparing(AppointmentDTO::getBookingTime));
				
				tomorrowList.sort(Comparator.comparing(AppointmentDTO::getBookingDate)
						.thenComparing(AppointmentDTO::getBookingTime));
				doctorWithAppointments.add(withAppointment);
			}
			return doctorWithAppointments;
		} else {
			throw new DoctorNotFoundException("Doctor Not Found");
		}
	}

}
