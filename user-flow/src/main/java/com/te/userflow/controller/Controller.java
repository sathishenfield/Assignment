package com.te.userflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.userflow.dto.AppointmentDTO;
import com.te.userflow.dto.AppointmentResponse;
import com.te.userflow.dto.AuthenticateRequest;
import com.te.userflow.dto.AuthenticateResponse;
import com.te.userflow.dto.DoctorDTO;
import com.te.userflow.dto.DoctorWithAppointment;
import com.te.userflow.dto.UserDTO;
import com.te.userflow.exception.InvalidCredentialException;
import com.te.userflow.jwtutil.JWTUtil;
import com.te.userflow.response.Response;
import com.te.userflow.service.AppointmentService;
import com.te.userflow.service.DoctorService;
import com.te.userflow.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {

	@Autowired
	private UserService userService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/login")
	public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest authenticateRequest) {

		try {
			System.out.println("Inside authenticate");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getName(),
					authenticateRequest.getPassword()));
			System.out.println("After Authenticate");
			UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getName());
			System.out.println("Inside authenticate2");
			String generateToken = jwtUtil.generateToken(userDetails);
			System.out.println(generateToken);
			return new ResponseEntity<AuthenticateResponse>(new AuthenticateResponse(generateToken), HttpStatus.OK);

		} catch (Exception e) {
			throw new InvalidCredentialException("Invalid credential");
		}

	}

	@PostMapping("/adduser")
	public ResponseEntity<Response> registerUser(@RequestBody UserDTO userDTO) {

		UserDTO registerUser = userService.registerUser(userDTO);
		if (registerUser != null) {
			return new ResponseEntity<Response>(
					Response.builder().msg("User Registered").data(registerUser).err(false).build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(
					Response.builder().msg("User Not Registered").data(registerUser).err(true).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAllDoctor")
	public ResponseEntity<?> getAllDoctor() {

		List<DoctorDTO> allDoctor = doctorService.getAllDoctor();
		if (!allDoctor.isEmpty()) {
			return new ResponseEntity<List<DoctorDTO>>(allDoctor, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<DoctorDTO>>(allDoctor, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getDoctor")
	public ResponseEntity<?> getDoctorByName(String name) {

		List<DoctorDTO> doctorByName = doctorService.getDoctorByName(name);
		if (!doctorByName.isEmpty()) {
			return new ResponseEntity<List<DoctorDTO>>(doctorByName, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<DoctorDTO>>(doctorByName, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/bookAppointment/{doctorId}")
	public ResponseEntity<Response> bookAppointment(@RequestBody AppointmentDTO appointmentDTO,
			@PathVariable Integer doctorId, HttpServletRequest request) {

		String header = request.getHeader("Authorization");
		String jwtToken = header.substring(7);
		String username = jwtUtil.extractUsername(jwtToken);

		AppointmentResponse bookAppointment = appointmentService.bookAppointment(appointmentDTO, doctorId, username);
		if (bookAppointment != null) {
			return new ResponseEntity<Response>(
					Response.builder().msg("Appointment Booked").data(bookAppointment).err(false).build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(
					Response.builder().msg("Appointment Booked").data(bookAppointment).err(true).build(),
					HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/doctorWithApp/{doctorName}")
	public ResponseEntity<Response> getDoctorWithAppointment(@PathVariable String doctorName) {
		List<DoctorWithAppointment> doctorWithAppointment = doctorService.getDoctorWithAppointment(doctorName);
		if (!doctorWithAppointment.isEmpty()) {
			return new ResponseEntity<Response>(
					Response.builder().msg("Doctor With Appointment").err(false).list(doctorWithAppointment).build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(
					Response.builder().msg("Doctor Not Found").err(true).list(doctorWithAppointment).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

}
